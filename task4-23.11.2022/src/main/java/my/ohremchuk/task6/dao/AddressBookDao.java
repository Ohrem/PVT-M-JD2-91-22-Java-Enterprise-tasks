package my.ohremchuk.task6.dao;

import my.ohremchuk.task6.entity.AddressBook;
import my.ohremchuk.task6.entity.Car;

public interface AddressBookDao {

    void create(AddressBook addressBook);

    void findIdFromPersistenceObjects();
}
