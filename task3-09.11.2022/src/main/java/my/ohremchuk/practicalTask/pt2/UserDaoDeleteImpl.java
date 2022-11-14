package my.ohremchuk.practicalTask.pt2;

import my.ohremchuk.mainTask.entity.BirthDay;
import my.ohremchuk.mainTask.entity.PersonalInfo;
import my.ohremchuk.mainTask.entity.Role;
import my.ohremchuk.mainTask.entity.User;
import my.ohremchuk.mainTask.util.hibernate.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.transaction.Transactional;
import java.time.LocalDate;

public class UserDaoDeleteImpl implements UserDaoDelete {

    private final SessionFactory sessionFactory;

    public UserDaoDeleteImpl() {
        this(HibernateUtil.buildSessionFactory());
    }

    public UserDaoDeleteImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
    public void delete(User user) {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            var session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            User loadedUser = session.load(User.class, user.getId());
            session.delete(loadedUser);
            session.getTransaction().commit();
        }
    }

    @Transactional
    @Override
    public void deleteByHQL(Role selectRole) {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            var session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            String hql = "DELETE FROM User " +
                         "WHERE role = :role";
            Query query = session.createQuery(hql);
            query.setParameter("role", selectRole);
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);
            session.getTransaction().commit();
        }
    }

    @Override
    public User find(Long id) {
        return sessionFactory.openSession().get(User.class, id);
    }

    public void create() {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            var session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            User user = User.builder()
                    .personalInfo(PersonalInfo.builder()
                            .firstname("milikaniaaa")
                            .lastname("zanderKilleraasass")
                            .birthDate(new BirthDay(LocalDate.of(2007, 1, 24)))
                            .userEmail("miliaa@gmail.ru")
                            .build())
                    .role(Role.ADMIN)
                    .id(2L)
                    .build();
            session.save(user);
            session.getTransaction().commit();
        }
    }
}
