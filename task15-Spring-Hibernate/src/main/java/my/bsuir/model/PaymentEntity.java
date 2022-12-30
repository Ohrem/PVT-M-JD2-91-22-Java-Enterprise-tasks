package my.bsuir.model;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "orderEntity")
@Table(name = "payment")
public class PaymentEntity implements BaseEntity<Long> {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(
            name = "increment",
            strategy = "org.hibernate.id.IncrementGenerator"
    )
    private Long id;
    private LocalDate paymentDate;
    private Double paymentSum;

    @OneToOne(mappedBy = "paymentEntity")
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;
}