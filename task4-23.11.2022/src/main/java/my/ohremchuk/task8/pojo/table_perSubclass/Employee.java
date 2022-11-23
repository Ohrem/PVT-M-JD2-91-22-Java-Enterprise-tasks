package my.ohremchuk.task8.pojo.table_perSubclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "employee123")
@Inheritance(strategy = InheritanceType.JOINED)

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

}
