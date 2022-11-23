package my.ohremchuk.task8.pojo.table_perSubclass;

import my.ohremchuk.util.HibernateUtil;
import org.hibernate.SessionFactory;

public class StoreData {
    public static void main(String[] args) {

        Employee e1 = new Employee();
        e1.setName("Ohrem");

        RegularEmployee e2 = new RegularEmployee();
        e2.setName("Vladimir Kush");
        e2.setSalary(50000);
        e2.setBonus(5);

        ContractEmployee e3 = new ContractEmployee();
        e3.setName("Anatoliy Mbape");
        e3.setPayPer_hour(1000);
        e3.setContractDuration("15 hours");

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            var session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            session.save(e1);
            session.save(e2);
            session.save(e3);
            session.getTransaction().commit();
        }
    }
}
