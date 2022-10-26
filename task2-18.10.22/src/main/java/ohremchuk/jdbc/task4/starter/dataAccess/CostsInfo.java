package ohremchuk.jdbc.task4.starter.dataAccess;
import java.sql.SQLException;

public interface CostsInfo {

    void readAllFromDb() throws SQLException;

    void deleteRecordsFromDb();

    void addExpensesToDb(int id, double amount) throws SQLException;
}
