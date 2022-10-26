package ohremchuk.jdbc.task7.entity;
import lombok.Data;

@Data
public class Receiver {
    private Integer userId;
    private String name;
    private String email;

    public Receiver(String name, String email, Integer userId) {
        this.name = name;
        this.email = email;
        this.userId = userId;
    }
    public Receiver() {

    }

    @Override
    public String toString() {
        return "Receiver{" +
               "userId=" + userId +
               ", name='" + name + '\'' +
               ", email='" + email + '\'' +
               '}' + "\n";
    }
}

