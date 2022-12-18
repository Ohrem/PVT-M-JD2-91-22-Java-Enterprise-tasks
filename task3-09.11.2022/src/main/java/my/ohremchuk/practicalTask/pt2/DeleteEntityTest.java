package my.ohremchuk.practicalTask.pt2;

import my.ohremchuk.mainTask.entity.Role;
import my.ohremchuk.mainTask.entity.User;

public class DeleteEntityTest {

    public static void main(String[] args) {
        UserDaoDeleteImpl targetObject = new UserDaoDeleteImpl();
        targetObject.deleteByHQL(Role.TROLLER);

//        targetObject.create();

        User user = targetObject.find(14L);
        targetObject.delete(user);


    }
}

