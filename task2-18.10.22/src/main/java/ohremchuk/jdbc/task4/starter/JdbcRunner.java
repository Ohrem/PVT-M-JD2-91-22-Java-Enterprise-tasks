package ohremchuk.jdbc.task4.starter;

import ohremchuk.jdbc.task4.starter.userInteraction.Interaction;
import ohremchuk.jdbc.util.ConnectionManager;

import java.sql.SQLException;


public class JdbcRunner {
    public static void main(String[] args) throws SQLException {
        Interaction interaction = new Interaction();
        try {
            interaction.displayInConsole();
        }
        finally {
            ConnectionManager.closePool();
        }
    }
}
