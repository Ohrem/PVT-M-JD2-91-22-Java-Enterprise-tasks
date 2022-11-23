package my.ohremchuk.task7;

import lombok.Cleanup;
import my.ohremchuk.task7.entity.Birthday;
import my.ohremchuk.task7.entity.Company;
import my.ohremchuk.task7.entity.PersonalInfo;
import my.ohremchuk.task7.entity.User;
import my.ohremchuk.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.junit.Test;

import java.time.LocalDate;

public class HibernateRunnerTest {
    @Test
    public void oneToMany() {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             var session = sessionFactory.openSession()) {
            session.beginTransaction();

            var company = session.get(Company.class, 1);
            System.out.println(company.getUsers());

            session.getTransaction().commit();
        }
    }

    @Test
    public void checkOrhanRemoval() {
        try (var sessionFactory = HibernateUtil.buildSessionFactory();
             var session = sessionFactory.openSession()) {
            session.beginTransaction();

            Company company = session.getReference(Company.class, 4);
            company.getUsers().removeIf(user -> user.getId().equals(5L));

            session.getTransaction().commit();
        }
    }

    @Test
    public void addUserToNewCompany() {
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();

        var company = Company.builder()
                .name("VK")
                .build();

        var user = User.builder()
                .personalInfo(PersonalInfo.builder()
                        .firstname("Anton")
                        .lastname("Vasiliev")
                        .birthDate(new Birthday(LocalDate.of(20,12,10)))
                        .build())
                .company(company)
                .username("Antosha@fish2AA")
                .build();

        company.addUser(user);

        session.save(company);

        session.getTransaction().commit();
    }
}
