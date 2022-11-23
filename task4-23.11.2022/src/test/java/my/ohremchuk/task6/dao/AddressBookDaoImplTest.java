package my.ohremchuk.task6.dao;

import my.ohremchuk.task6.entity.AddressBook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class AddressBookDaoImplTest {

    AddressBookDaoImpl targetObject;

    @Before
    public void setUp() {
        targetObject = new AddressBookDaoImpl();
    }

    @After
    public void tearDown() {
        targetObject = null;
    }

    @Test
    public void create() {
            AddressBook addressBook = AddressBook.builder()
                    .name("Iliya")
                    .phone_number("+37544345232")
                    .streetAddress("Pushkina")
                    .city("Borisov")
                    .build();
            targetObject.create(addressBook);
        }

    @Test
    public void findIdFromPersistenceObjects() {
            targetObject.findIdFromPersistenceObjects();
    }
}