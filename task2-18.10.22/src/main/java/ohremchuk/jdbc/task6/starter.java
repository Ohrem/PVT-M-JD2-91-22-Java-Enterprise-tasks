package ohremchuk.jdbc.task6;

import ohremchuk.jdbc.task6.dataAccess.SelectQuery;

import java.sql.SQLException;

public class starter {
    public static void main(String[] args) throws SQLException {
        SelectQuery selectQuery = new SelectQuery();
        selectQuery.readAllPayeesAndAmountOfPayments();
        selectQuery.getSumAmountWhenMaxPayment();
        selectQuery.getMaxValueWhenMaxSum();
    }
}
