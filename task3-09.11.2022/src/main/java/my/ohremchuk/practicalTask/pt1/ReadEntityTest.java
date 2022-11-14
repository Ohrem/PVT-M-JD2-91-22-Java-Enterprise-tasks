package my.ohremchuk.practicalTask.pt1;

import my.ohremchuk.mainTask.entity.User;
import my.ohremchuk.mainTask.util.hibernate.HibernateUtil;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;

public class ReadEntityTest {

    public static void main(String[] args) {
        //getUserById(10L);
        loadUserById(11l);
    }

    @Transactional
    private static void getUserById(Long id) {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            var session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null) {
                System.out.println(user.getId() + "\t" + user.getPersonalInfo().getFirstname() + "\t" + user.getPersonalInfo().getLastname() + "\t"
                        + user.getPersonalInfo().getUserEmail() + "\t" + user.getPersonalInfo().getBirthDate().getAge() + "\t"
                        + user.getRole());
            } else {
                System.out.println("User doesnt exist");
            }
        }
    }
    @Transactional
    private static void loadUserById(Long id){
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            var session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            User user = session.load(User.class, id);
            if (user != null) {
                System.out.println(user.getId() + "\t" + user.getPersonalInfo().getFirstname() + "\t" + user.getPersonalInfo().getLastname() + "\t"
                                   + user.getPersonalInfo().getUserEmail() + "\t" + user.getPersonalInfo().getBirthDate().getAge() + "\t"
                                   + user.getRole());
            } else {
                System.out.println("User doesnt exist");
            }
        }
    }
}
