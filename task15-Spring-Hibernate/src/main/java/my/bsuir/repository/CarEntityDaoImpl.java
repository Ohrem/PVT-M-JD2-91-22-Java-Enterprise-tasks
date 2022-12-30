package my.bsuir.repository;

import my.bsuir.model.CarEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CarEntityDaoImpl implements CarEntityDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(CarEntity car) {
        sessionFactory.getCurrentSession().saveOrUpdate(car);
    }

    @Override
    public CarEntity findById(long id) {
        return sessionFactory.getCurrentSession().get(CarEntity.class, id);
    }


    @Override
    public void update(CarEntity car) {
        create(car);
    }

    @Override
    @Transactional(transactionManager = "transactionManager")
    public void delete(long id) {
        sessionFactory.getCurrentSession().createQuery("delete from CarEntity where id=" + id).executeUpdate();
    }

    @Override
    public void delete(CarEntity car) {
        Session session = sessionFactory.getCurrentSession();
        session.refresh(car);
        session.delete(car);
    }
}
