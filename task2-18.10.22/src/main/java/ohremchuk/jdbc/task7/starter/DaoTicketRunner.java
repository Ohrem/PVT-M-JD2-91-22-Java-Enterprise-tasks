package ohremchuk.jdbc.task7.starter;

import ohremchuk.jdbc.task7.dao.TicketDao;
import ohremchuk.jdbc.task7.dto.TicketFilter;
import ohremchuk.jdbc.task7.entity.Ticket;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class DaoTicketRunner {
    public static void main(String[] args) {
//        saveTest();
//        filterTest();
//        findAllRecordsTest();
//        updateTicketTest();
        deleteTicketTest(16);

    }

    private static void filterTest() {
        var ticketFilter = new TicketFilter(10, 0, 32.05, "2022-10-23");
        List<Ticket> tickets = TicketDao.getInstance().findAll(ticketFilter);
        System.out.println(tickets);
    }

    private static void findAllRecordsTest() {
        var tickets = TicketDao.getInstance().findAll();
        System.out.println(tickets);
    }

    private static void updateTicketTest() {
        var ticketDao = TicketDao.getInstance();
        var maybeExistTicket = ticketDao.findById(3);
        System.out.println(maybeExistTicket);

        maybeExistTicket.ifPresent(ticket -> {
            ticket.setAmount(BigDecimal.valueOf(60.32));
            ticketDao.update(ticket);
        });
    }

    private static void deleteTicketTest(int id) {
        var ticketDao = TicketDao.getInstance();
        var deleteResult = ticketDao.delete(id);
        System.out.println(deleteResult);
    }

    private static void saveTest() {
        var ticketDao = TicketDao.getInstance();
        var ticket = new Ticket();
        ticket.setClientId(1);
        ticket.setAmount(BigDecimal.valueOf(97.23));
        ticket.setDate(Date.valueOf("2022-10-26"));
        var savedTicket = ticketDao.save(ticket);
        System.out.println(savedTicket);
    }
}
