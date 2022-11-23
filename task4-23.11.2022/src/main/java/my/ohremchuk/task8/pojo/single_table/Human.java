package my.ohremchuk.task8.pojo.single_table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "HUMAN_TYPE",
        discriminatorType = DiscriminatorType.STRING
)
public class Human {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(
            name = "increment",
            strategy = "org.hibernate.id.IncrementGenerator"
    )
    private int id;

    private String name;

    private int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
