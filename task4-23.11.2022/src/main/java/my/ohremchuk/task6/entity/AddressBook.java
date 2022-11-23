package my.ohremchuk.task6.entity;

import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "address_book")
@Entity
public class AddressBook implements BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_book_seq")
    @SequenceGenerator(name = "address_book_seq", sequenceName = "t_book_seq")
    private Long id;
    @Column
    private String name;
    @Column
    private String phone_number;
    @Column
    private String streetAddress;
    @Column
    private String city;
}
