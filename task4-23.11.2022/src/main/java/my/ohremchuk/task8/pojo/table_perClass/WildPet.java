package my.ohremchuk.task8.pojo.table_perClass;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class WildPet extends Animal {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(
            name = "increment",
            strategy = "org.hibernate.id.IncrementGenerator"
    )
    private int id;

    private boolean isPredator;

    public WildPet(String species, int height, boolean isPredator) {
        super(species, height);
        this.isPredator = isPredator;
    }
}