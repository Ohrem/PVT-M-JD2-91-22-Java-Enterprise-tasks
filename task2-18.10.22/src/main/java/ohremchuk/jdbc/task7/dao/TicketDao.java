package ohremchuk.jdbc.task7.dao;
import ohremchuk.jdbc.task7.dto.TicketFilter;
import ohremchuk.jdbc.task7.entity.Ticket;
import ohremchuk.jdbc.task7.exception.DaoException;
import ohremchuk.jdbc.util.ConnectionManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static java.util.stream.Collectors.joining;

public class TicketDao implements BaseDao<Ticket> {
    private static final TicketDao INSTANCE = new TicketDao();

    private TicketDao() {

    }

    public static final String DELETE_SQL = """
            DELETE FROM payment_ticket
            WHERE id_payment_ticket = ?
            """;
    public static final String SAVE_SQL = """
            INSERT INTO payment_ticket (id_client, pay_date, payment_amount) 
            VALUES (?,?,?);
            """;
    public static final String UPDATE_SQL = """
            UPDATE payment_ticket
            SET id_client = ?,
                pay_date = ?,
                payment_amount = ?
            WHERE id_payment_ticket = ? 
            """;
    public static final String FIND_ALL_SQL = """
             SELECT id_payment_ticket,
                 id_client,
                 payment_amount,
                 pay_date
            FROM payment_ticket
            """;

    public static final String FIND_BY_ID_SQL = FIND_ALL_SQL + """
            WHERE id_payment_ticket = ?
                        
             """;

    public List<Ticket> findAll(TicketFilter filter) {
        List<Object> params = new ArrayList<>();
        List<String> whrereSql = new ArrayList<>();
        if (filter.getAmount() != null) {
            whrereSql.add("payment_amount < ?");
            params.add(filter.getAmount());
        }
        if (filter.getPayDate() != null){
            whrereSql.add("pay_date = ?");
            params.add(filter.getPayDate());
        }
        params.add(filter.getLimit());
        params.add(filter.getOffset());
        var where = whrereSql.stream()
                .collect(joining(" AND ", " WHERE ", " LIMIT ? OFFSET ? "));
        String DYNAMIC_SQL = FIND_ALL_SQL + where;

        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(DYNAMIC_SQL)) {
            for (int i = 0; i < params.size(); i++) {
                preparedStatement.setObject(i + 1, params.get(i));
            }
            System.out.println("--------Query--------+\n" + preparedStatement + "\n--------Query--------+\n");
            var resultSet = preparedStatement.executeQuery();
            List<Ticket> tickets = new ArrayList<>();
            while (resultSet.next()) {
                tickets.add(buildTicket(resultSet));
            }
            return tickets;
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    public List<Ticket> findAll() {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_ALL_SQL)) {
            var resultSet = preparedStatement.executeQuery();
            List<Ticket> tickets = new ArrayList<>();
            while (resultSet.next()) {
                tickets.add(buildTicket(resultSet));
            }
            return tickets;
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    public Optional<Ticket> findById(Integer id) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);
            var resultSet = preparedStatement.executeQuery();
            Ticket ticket = null;
            if (resultSet.next()) {
                ticket = buildTicket(resultSet);
            }
            return Optional.ofNullable(ticket);
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    private Ticket buildTicket(ResultSet resultSet) throws SQLException {
        return new Ticket(
                resultSet.getInt("id_client"),
                resultSet.getDate("pay_date"),
                resultSet.getInt("id_payment_ticket"),
                resultSet.getBigDecimal("payment_amount")
        );
    }

    public void update(Ticket ticket) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
            preparedStatement.setInt(1, ticket.getClientId());
            preparedStatement.setDate(2, (Date) ticket.getDate());
            preparedStatement.setBigDecimal(3, ticket.getAmount());
            preparedStatement.setInt(4, ticket.getTicketId());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    public Ticket save(Ticket ticket) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, ticket.getClientId());
            preparedStatement.setDate(2, (Date) ticket.getDate());
            preparedStatement.setBigDecimal(3, ticket.getAmount());

            preparedStatement.executeUpdate();
            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                ticket.setTicketId(generatedKeys.getInt(1));
            }
            return ticket;
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    public boolean delete(int id) {
        try (var connection = ConnectionManager.get();
             var deleteTicketPreparedStatement = connection.prepareStatement(DELETE_SQL)) {
            deleteTicketPreparedStatement.setInt(1, id);
            return deleteTicketPreparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    public static TicketDao getInstance() {
        return INSTANCE;
    }
}
