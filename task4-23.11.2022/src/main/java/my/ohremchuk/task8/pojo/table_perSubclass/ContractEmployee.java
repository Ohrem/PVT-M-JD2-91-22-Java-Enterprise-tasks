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
@Table(name = "contract_employee_123")
@PrimaryKeyJoinColumn(name = "ID")
public class ContractEmployee extends Employee {

    @Column(name = "pay_per_hour")
    private float payPer_hour;

    @Column(name = "contract_duration")
    private String contractDuration;

    //setters and getters
}
