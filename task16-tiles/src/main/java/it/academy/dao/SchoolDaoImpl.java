package it.academy.dao;

import it.academy.model.School;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SchoolDaoImpl implements SchoolDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(School school) {

        sessionFactory.getCurrentSession().saveOrUpdate(school);
    }

    @Override
    public School getSchoolById(Integer id) {

        return sessionFactory.getCurrentSession()
                .get(School.class, id);
    }

    @Override
    public void delete(Integer id) {
        sessionFactory.getCurrentSession().delete(getSchoolById(id));
    }
}

