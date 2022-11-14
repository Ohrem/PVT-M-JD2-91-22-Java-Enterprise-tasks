package my.ohremchuk.mainTask.entity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Entity;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "users", schema = "expenses_repository")
public class User implements BaseEntity<Long> {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "org.hibernate.id.IncrementGenerator")
    private Long id;

    @Embedded
    @AttributeOverride(name = "birthDate", column = @Column(name = "birth_date"))
    private PersonalInfo personalInfo;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}