package my.ohremchuk.task8.pojo.table_perClass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class HomePet extends Animal {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(
            name = "increment",
            strategy = "org.hibernate.id.IncrementGenerator"
    )
    private int id;

    private String name;

    private int age;

    public HomePet(String species, int height, String name, int age) {
        super(species, height);
        this.name = name;
        this.age = age;
    }
}