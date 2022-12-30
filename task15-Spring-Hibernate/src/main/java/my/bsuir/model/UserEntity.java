package my.bsuir.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "user")
public class UserEntity implements BaseEntity<Long> {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(
            name = "increment",
            strategy = "org.hibernate.id.IncrementGenerator"
    )
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;
    @Enumerated(value = EnumType.STRING)
    private UserRole role;
    private BigDecimal balance;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserPhoto userPhoto;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "userEntities", fetch = FetchType.EAGER)
    private List<OrderEntity> orderList;
}