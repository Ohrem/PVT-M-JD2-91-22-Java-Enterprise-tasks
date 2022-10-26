package ohremchuk.jdbc.task6.dataAccess;
import ohremchuk.jdbc.util.ConnectionManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectQuery {

    private final String PAYEES_AND_SUM_AMOUNT_SQL = """
            SELECT id_user, name, email, SUM(payment_amount) 'sum'
            from receiver right join payment_ticket pt on id_user  = pt.id_client group by pt.id_client;
            """;

    private final String SUM_SQL = """
            SELECT SUM(payment_amount) FROM payment_ticket WHERE pay_date IN
            (SELECT distinct pay_date FROM payment_ticket where payment_amount IN
            (select MAX(payment_amount)from payment_ticket))
            """;

    private final String MAX_VALUE_SQL = """
            SELECT MAX(payment_amount) FROM payment_ticket WHERE pay_date = (
                SELECT pay_date FROM payment_ticket GROUP BY pay_date ORDER BY sum(payment_amount) DESC 
                LIMIT 1);
            """;

    public void readAllPayeesAndAmountOfPayments() throws SQLException {
        try (var connection = ConnectionManager.get();
             var statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            var executeResult = statement.executeQuery(PAYEES_AND_SUM_AMOUNT_SQL);

            while (executeResult.next()) {
                Entity model = new Entity(executeResult.getInt(1), executeResult.getString(2),
                        executeResult.getString(3), executeResult.getDouble(4));
                System.out.println(model);
            }
        }
    }

    public void getSumAmountWhenMaxPayment() {
        try (var connection = ConnectionManager.get();
             var statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            var executeResult = statement.executeQuery(SUM_SQL);
            while (executeResult.next()) {
                System.out.println("sum: " + executeResult.getBigDecimal(1));
            }
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    public void getMaxValueWhenMaxSum() {
        try (var connection = ConnectionManager.get();
             var statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            var executeResult = statement.executeQuery(MAX_VALUE_SQL);
            while (executeResult.next()) {
                System.out.println("maxValue: " + executeResult.getBigDecimal(1));
            }
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }
}

