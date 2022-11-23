package my.ohremchuk.task8.pojo.single_table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("CLIENT_TYPE")
public class Client extends Human {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(
            name = "increment",
            strategy = "org.hibernate.id.IncrementGenerator"
    )
    private int id;

    private int balance;

    public Client(String name, int age, int balance) {
        super(name, age);
        this.balance = balance;
    }
}
