package ohremchuk.jdbc.task7.dto;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
public class TicketFilter {
    int limit;
    int offset;
    Double amount;
    String payDate;

    public TicketFilter() {
    }

    public TicketFilter(int limit, int offset) {
        this.limit = limit;
        this.offset = offset;
    }

    public TicketFilter(int limit, int offset, Double amount) {
        this.limit = limit;
        this.offset = offset;
        this.amount = amount;
    }

    public TicketFilter(int limit, int offset, String payDate) {
        this.limit = limit;
        this.offset = offset;
        this.payDate = payDate;
    }

    public TicketFilter(int limit, int offset, Double amount, String payDate) {
        this.limit = limit;
        this.offset = offset;
        this.amount = amount;
        this.payDate = payDate;
    }
}
