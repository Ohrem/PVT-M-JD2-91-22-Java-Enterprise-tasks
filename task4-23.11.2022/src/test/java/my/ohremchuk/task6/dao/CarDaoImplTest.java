package my.ohremchuk.task6.dao;

import my.ohremchuk.task6.entity.Car;
import my.ohremchuk.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class CarDaoImplTest {
    CarDaoImpl targetObject;

    @Before
    public void setUp() {
        targetObject = new CarDaoImpl();
    }

    @After
    public void tearDown() {
        targetObject = null;
    }

    @Test
    public void create() {
            Car car = Car.builder()
                    .brand("Mers")
                    .model("X7M")
                    .salePrice(BigDecimal.valueOf(114.45))
                    .build();
            targetObject.create(car);
    }

    @Test
    public void findIdByModel() {
        targetObject.findIdFromPersistenceObjects();
    }
}