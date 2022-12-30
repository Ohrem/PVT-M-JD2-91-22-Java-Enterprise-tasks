package my.bsuir.service;

import my.bsuir.model.CarEntity;
import my.bsuir.repository.CarEntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarService {

    @Autowired
    private CarEntityDao carEntityDao;

    @Transactional(propagation = Propagation.NESTED)
    public void add(CarEntity car) {
        carEntityDao.create(car);
    }

}
