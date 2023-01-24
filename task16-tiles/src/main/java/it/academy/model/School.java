package it.academy.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Getter
@Table(name = "school")
@Entity

public class School implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(
            name = "increment",
            strategy = "org.hibernate.id.IncrementGenerator"
    )
    private Integer id;

    @Column(name = "schoolName")
    private String schoolName;

    @Column(name = "schoolNumber")
    private Integer schoolNumber;

    @Column(name = "valueOfStudents")
    private Integer valueOfStudents;

}


