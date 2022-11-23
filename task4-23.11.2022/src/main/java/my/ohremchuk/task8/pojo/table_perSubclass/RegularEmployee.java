package my.ohremchuk.task8.pojo.table_perSubclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "regular_employee123")
@PrimaryKeyJoinColumn(name = "ID")
public class RegularEmployee extends Employee {

    @Column(name = "salary")
    private float salary;

    @Column(name = "bonus")
    private int bonus;

}
