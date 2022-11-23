package my.ohremchuk.task6.dao;

import my.ohremchuk.task6.entity.Car;
import my.ohremchuk.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CarDaoImpl implements CarDao {

    private final SessionFactory sessionFactory;

    public CarDaoImpl() {
        this.sessionFactory = HibernateUtil.buildSessionFactory();
    }

    public CarDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Car car) {
        Transaction tx = null;
        try (Session sess = sessionFactory.openSession()) {
            tx = sess.beginTransaction();
            sess.saveOrUpdate(car);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public void findIdFromPersistenceObjects() {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            var session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            String hql = "SELECT id FROM Car ";
            Query query = session.createQuery(hql);
            List<Long> results = query.list();
            for (Long result : results) {
                System.out.println("id:" + result);
            }
            session.getTransaction().commit();
        }
    }

}


