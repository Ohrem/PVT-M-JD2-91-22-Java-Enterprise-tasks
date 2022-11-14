package ohremchuk.jdbc.task5.starter;

import ohremchuk.jdbc.task5.starter.dataAccess.PrecompiledOutlayImp;

import java.sql.SQLException;

public class TransactionRunner {
    public static void main(String[] args) throws SQLException {
        //findByIDTest();
        //deleteByIdTest();
        //    outlayImp.deleteTicketById(3L);
    }

    private static void deleteByIdTest() throws SQLException {
        PrecompiledOutlayImp outlayImp = new PrecompiledOutlayImp();
        outlayImp.deleteTicketById(3L);
    }

    private static void findByIDTest() throws SQLException {
        PrecompiledOutlayImp outlayImp = new PrecompiledOutlayImp();
        Long ticket_id = 3L;
        var result = outlayImp.getExpensesTicketById(ticket_id);
        System.out.println(result);
    }

}
