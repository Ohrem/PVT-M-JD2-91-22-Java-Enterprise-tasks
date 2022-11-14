package my.ohremchuk.practicalTask.pt2;

import my.ohremchuk.mainTask.entity.Role;
import my.ohremchuk.mainTask.entity.User;

public interface UserDaoDelete {

    void deleteByHQL(Role role);

    void delete(User user);

    User find(Long id);

    void create();

}
