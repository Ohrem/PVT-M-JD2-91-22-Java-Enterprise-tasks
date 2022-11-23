package my.ohremchuk.task6.dao;

import my.ohremchuk.task6.entity.AddressBook;
import my.ohremchuk.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AddressBookDaoImpl implements AddressBookDao {
    private final SessionFactory sessionFactory;

    public AddressBookDaoImpl() {
        this.sessionFactory = HibernateUtil.buildSessionFactory();
    }

    public AddressBookDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(AddressBook addressBook) {
        Transaction tx = null;
        try (Session sess = sessionFactory.openSession()) {
            tx = sess.beginTransaction();
            sess.saveOrUpdate(addressBook);
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
            String hql = "SELECT id FROM AddressBook ";
            Query query = session.createQuery(hql);
            List<Long> results = query.list();
            for (Long result : results) {
                System.out.println("id:" + result);
            }
            session.getTransaction().commit();
        }
    }
}
