package my.ohremchuk.mainTask.dao;
import my.ohremchuk.mainTask.entity.User;

import java.util.List;

public interface UserDao {
    void create(User user);

    User findById(long id);

    void update(User user);

    void delete(User user);

    List<User> readAll();
}