package my.bsuir.service;
import my.bsuir.model.UserEntity;
import my.bsuir.model.UserPhoto;
import my.bsuir.repository.UserEntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserEntityDao userEntityDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void add(UserEntity user, byte[] photo) {

        if (user.getUserPhoto() == null) {
            UserPhoto userPhoto = new UserPhoto();
            userPhoto.setUser(user);
            userPhoto.setPhoto(photo);
            user.setUserPhoto(userPhoto);
        }
        userEntityDao.create(user);
    }

    @Transactional(readOnly = true)
    public List<UserEntity> getAll() {
        return userEntityDao.findAll();
    }

    public UserEntity getById(long userId) {
        return userEntityDao.findById(userId);
    }

}
