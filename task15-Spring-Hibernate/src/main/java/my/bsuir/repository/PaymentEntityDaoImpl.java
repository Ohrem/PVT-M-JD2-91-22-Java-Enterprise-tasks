package my.bsuir.repository;

import my.bsuir.model.PaymentEntity;
import my.bsuir.model.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PaymentEntityDaoImpl implements PaymentEntityDao {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void create(PaymentEntity payment) {
        sessionFactory.getCurrentSession().saveOrUpdate(payment);
    }

    @Override
    public List<PaymentEntity> readAll() {
        return sessionFactory.getCurrentSession().createQuery("from PaymentEntity ", PaymentEntity.class).list();
    }

    @Override
    public void update(PaymentEntity payment) {
        create(payment);
    }

    @Override
    public void delete(PaymentEntity payment) {
        PaymentEntity loadedPayment = sessionFactory.getCurrentSession().load(PaymentEntity.class, payment.getId());
        sessionFactory.getCurrentSession().delete(loadedPayment);
    }
}
