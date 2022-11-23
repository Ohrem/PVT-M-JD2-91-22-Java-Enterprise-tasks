package my.ohremchuk.task6.dao;

import my.ohremchuk.task6.entity.AddressBook;
import my.ohremchuk.task6.entity.Car;

public interface CarDao {

        void create(Car car);

        void findIdFromPersistenceObjects();
    }

