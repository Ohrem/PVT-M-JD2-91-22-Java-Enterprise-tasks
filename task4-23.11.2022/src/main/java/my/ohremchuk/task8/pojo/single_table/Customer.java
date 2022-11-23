package my.ohremchuk.task8.pojo.single_table;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@DiscriminatorValue("USER_TYPE")
public class Customer extends Human {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(
            name = "increment",
            strategy = "org.hibernate.id.IncrementGenerator"
    )
    private int id;

    private String nickName;

    public Customer(String name, int age, String nickName) {
        super(name, age);
        this.nickName = nickName;
    }
}
