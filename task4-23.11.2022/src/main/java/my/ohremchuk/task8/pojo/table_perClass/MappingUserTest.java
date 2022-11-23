package my.ohremchuk.task8.pojo.table_perClass;

import my.ohremchuk.util.HibernateUtil;
import org.hibernate.SessionFactory;

public class MappingUserTest {
    public static void main(String[] args) {
       Animal animal = new Animal("Birds", 15);
       HomePet homePet = new HomePet("Grizzly", 110, "Grizzz", 8);
       WildPet wildPet = new WildPet("Tiger", 89, true);

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            var session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            session.save(animal);
            session.save(homePet);
            session.save(wildPet);
            session.getTransaction().commit();
        }
    }
}
