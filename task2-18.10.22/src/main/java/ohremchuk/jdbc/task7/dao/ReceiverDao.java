package ohremchuk.jdbc.task7.dao;

import ohremchuk.jdbc.task7.entity.Receiver;
import ohremchuk.jdbc.task7.entity.Ticket;
import ohremchuk.jdbc.task7.exception.DaoException;
import ohremchuk.jdbc.util.ConnectionManager;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReceiverDao implements BaseDao<Receiver> {
    private static final ReceiverDao INSTANCE = new ReceiverDao();
    public static final String SAVE_SQL = """
            INSERT INTO receiver (name, email) 
            VALUES (?,?);
            """;

    public static final String DELETE_SQL = """
            DELETE FROM receiver
            WHERE id_user = ?
            """;
    //language=SQL
    public static final String FIND_ALL_SQL = """
             SELECT name,
                 email,
                 id_user
            FROM receiver
            """;

    public static final String FIND_BY_ID_SQL = FIND_ALL_SQL + """
            WHERE id_user = ?
             """;

    public static final String UPDATE_SQL = """
            UPDATE receiver
            SET name = ?,
                email = ?
            WHERE id_user = ? 
            """;

    private ReceiverDao() {

    }


    @Override
    public List<Receiver> findAll() {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_ALL_SQL)) {
            var resultSet = preparedStatement.executeQuery();
            List<Receiver> receivers = new ArrayList<>();
            while (resultSet.next()) {
                receivers.add(buildReceiver(resultSet));
            }
            return receivers;
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }
    private Receiver buildReceiver(ResultSet resultSet) throws SQLException {
        return new Receiver(
               resultSet.getString("name"),
                resultSet.getString("email"),
                resultSet.getInt("id_user")
        );
    }

    @Override
    public Optional<Receiver> findById(Integer id) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);
            var resultSet = preparedStatement.executeQuery();
            Receiver receiver = null;
            if (resultSet.next()) {
                receiver = buildReceiver(resultSet);
            }
            return Optional.ofNullable(receiver);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Receiver save(Receiver receiver) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, receiver.getName());
            preparedStatement.setString(2, receiver.getEmail());
            preparedStatement.executeUpdate();
            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                receiver.setUserId(generatedKeys.getInt(1));
            }
            return receiver;
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    public void update(Receiver receiver) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
            preparedStatement.setString(1, receiver.getName());
            preparedStatement.setString(2, receiver.getEmail());
            preparedStatement.setInt(3, receiver.getUserId());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }


    @Override
    public boolean delete(int id) {
        try (var connection = ConnectionManager.get();
             var deleteTicketPreparedStatement = connection.prepareStatement(DELETE_SQL)) {
            deleteTicketPreparedStatement.setInt(1, id);
            return deleteTicketPreparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    public static ReceiverDao getInstance() {
        return INSTANCE;
    }
}
