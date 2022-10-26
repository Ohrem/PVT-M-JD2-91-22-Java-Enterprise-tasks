package ohremchuk.jdbc.task5.starter.dataAccess;

import ohremchuk.jdbc.util.ConnectionManager;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class PrecompiledOutlayImp implements Outlay {
    @Override
    public void addCostsToDb(int id, double value) throws SQLException {
        String sql = """
                     INSERT INTO expenses (ticket_id, costs_amount) VALUES (?,?)
                """;
        try (var connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(sql)) {
            prepareStatement.setInt(1, id);
            prepareStatement.setBigDecimal(2, new BigDecimal(value));
            var row = prepareStatement.executeUpdate();
        }
    }

    @Override
    public Map<Integer, Double> getExpensesTicketById(Long ticketId) throws SQLException {
        final String sql = """
                SELECT ticket_id,costs_amount
                FROM expenses
                WHERE ticket_id = ?
                """;
        Map<Integer, Double> result = new HashMap<>();
        try (var connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(sql)) {
            prepareStatement.setFetchSize(50);
            prepareStatement.setQueryTimeout(10);
            prepareStatement.setMaxRows(100);
            prepareStatement.setLong(1, ticketId);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                result.put(resultSet.getObject("ticket_id", Integer.class),
                        resultSet.getObject("costs_amount", Double.class));
            }
        }
        return result;
    }

    @Override
    public void deleteTicketById(Long id) throws SQLException {
        String deleteSql = """
                DELETE FROM expenses WHERE ticket_id = ?
                 """;
        try (var connection = ConnectionManager.get();
             var deleteTicketsStatement = connection.prepareStatement(deleteSql)) {
            deleteTicketsStatement.setLong(1, id);
            deleteTicketsStatement.executeUpdate();
            System.out.println("Deleted!");
        }
    }

    private static void checkMetaData() throws SQLException {
        try (var connection = ConnectionManager.get()) {
            var metaData = connection.getMetaData();
            var tables = metaData.getTables(connection.getCatalog(), connection.getSchema(), "%s", new String[]{"TABLE"});
            while (tables.next()) {
                System.out.println(tables.getString("TABLE_NAME"));
            }
        }
    }

}
