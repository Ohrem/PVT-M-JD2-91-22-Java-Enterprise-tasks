package my.bsuir.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "user_photo")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class UserPhoto {
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Lob
    @Column(name = "user_photo", columnDefinition = "MEDIUMBLOB NOT NULL")
    private byte[] photo;

}
