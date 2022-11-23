package my.ohremchuk.task8.pojo.single_table;

import my.ohremchuk.util.HibernateUtil;
import org.hibernate.SessionFactory;

public class MappingTest {
    public static void main(String[] args) {

        Human human = new Human("Sasha", 23);
        Customer user = new Customer("Anastasiya", 25, "Nas12_aaa");
        Client client = new Client("Slava", 30, 2000);

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            var session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            session.save(human);
            session.save(user);
            session.save(client);
            session.getTransaction().commit();
        }
    }
}
