package ohremchuk.jdbc.task7.entity;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class Ticket {
    private int clientId;
    private Date date;
    private int ticketId;
    private BigDecimal amount;

    public Ticket(){

    }

    public Ticket(int clientId, Date date, int ticketId, BigDecimal amount) {
        this.clientId = clientId;
        this.date = date;
        this.ticketId = ticketId;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Ticket {" +
               "clientId=" + clientId +
               ", date=" + date +
               ", ticketId=" + ticketId +
               ", amount=" + amount + " " +
               '}' + "\n";
    }
}
