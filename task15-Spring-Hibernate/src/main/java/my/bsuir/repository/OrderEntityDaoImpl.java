package my.bsuir.repository;

import my.bsuir.model.OrderEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public class OrderEntityDaoImpl implements OrderEntityDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(OrderEntity order) {
        sessionFactory.getCurrentSession().saveOrUpdate(order);
    }

    @Override
    public List<OrderEntity> readAll() {
        return sessionFactory.getCurrentSession().createQuery("from OrderEntity", OrderEntity.class).list();
    }

    @Override
    public void update(OrderEntity order) {
        create(order);
    }

    @Override
    public void delete(OrderEntity order) {
        OrderEntity loadedOrder = sessionFactory.getCurrentSession().load(OrderEntity.class, order.getId());
        sessionFactory.getCurrentSession().delete(loadedOrder);
    }
}
