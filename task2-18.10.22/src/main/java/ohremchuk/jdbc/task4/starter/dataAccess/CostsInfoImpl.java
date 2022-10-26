package ohremchuk.jdbc.task4.starter.dataAccess;

import ohremchuk.jdbc.util.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CostsInfoImpl implements CostsInfo {

    @Override
    public void readAllFromDb() throws SQLException {

        String sql = """
                SELECT *
                FROM expenses
                """;

        try (var connection = ConnectionManager.get();
             var statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            var executeResult = statement.executeQuery(sql);

            while (executeResult.next()) {
                System.out.println("ticket id: " + executeResult.getInt("ticket_id")
                                   + ", expenses amount: " + executeResult.getBigDecimal("costs_amount") + ";");
                System.out.println("----");
            }
        }
    }

    @Override
    public void deleteRecordsFromDb() {
        String sql = """
                TRUNCATE TABLE expenses;
                """;

        try (var connection = ConnectionManager.get();
             var statement = connection.createStatement()) {
            var executeResult = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addExpensesToDb(int id, double amount) throws SQLException {

        String sql = "INSERT INTO expenses (ticket_id, costs_amount)\n" +
                     "VALUES\n" +
                     " (" + id + "," + amount + ");\n";

        try (var connection = ConnectionManager.get();
             var statement = connection.createStatement()) {
            var executeResult = statement.executeUpdate(sql);
        }
    }
}
