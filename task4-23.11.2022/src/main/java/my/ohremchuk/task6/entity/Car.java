package my.ohremchuk.task6.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Car implements BaseEntity<Long> {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(
            name = "increment",
            strategy = "org.hibernate.id.IncrementGenerator"
    )
    private Long id;

    @Column
    private String brand;

    @Column
    private String model;

    @Column
    private BigDecimal salePrice;

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
