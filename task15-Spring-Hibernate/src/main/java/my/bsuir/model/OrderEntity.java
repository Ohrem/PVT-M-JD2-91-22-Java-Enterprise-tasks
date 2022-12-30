package my.bsuir.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@ToString(exclude = {"userEntities"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "orders")
public class OrderEntity implements BaseEntity<Long> {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(
            name = "increment",
            strategy = "org.hibernate.id.IncrementGenerator"
    )
    private Long id;

    @Column(name = "begin_date")
    private LocalDate beginDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    private CarEntity carEntity;

    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "payment_id")
    private PaymentEntity paymentEntity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntities;

    //TODO private OrderStatus orderStatus;
    private String message;
}
