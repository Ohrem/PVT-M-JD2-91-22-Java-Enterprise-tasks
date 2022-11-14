package my.ohremchuk.mainTask.repository;

import my.ohremchuk.mainTask.entity.User;

import javax.persistence.EntityManager;

public class UserDao extends DaoBase<Long, User> {

    public UserDao(EntityManager entityManager){
        super(entityManager, User.class);
    }

}
