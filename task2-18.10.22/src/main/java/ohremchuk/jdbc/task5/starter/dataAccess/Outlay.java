package ohremchuk.jdbc.task5.starter.dataAccess;

import java.sql.SQLException;
import java.util.Map;

public interface Outlay {

    void addCostsToDb(int id, double value) throws SQLException;
    Map<Integer, Double> getExpensesTicketById(Long ticketId) throws SQLException;
    void deleteTicketById(Long id) throws SQLException;

}
