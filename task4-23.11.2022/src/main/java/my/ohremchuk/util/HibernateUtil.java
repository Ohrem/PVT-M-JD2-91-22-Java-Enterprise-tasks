package my.ohremchuk.util;

import lombok.experimental.UtilityClass;
import my.ohremchuk.task6.entity.AddressBook;
import my.ohremchuk.task6.entity.Car;
import my.ohremchuk.task7.converter.BirthdayConverter;
import my.ohremchuk.task7.entity.Company;
import my.ohremchuk.task7.entity.User;
import my.ohremchuk.task8.pojo.table_perClass.Animal;
import my.ohremchuk.task8.pojo.table_perClass.HomePet;
import my.ohremchuk.task8.pojo.table_perClass.WildPet;
import my.ohremchuk.task8.pojo.single_table.Client;
import my.ohremchuk.task8.pojo.single_table.Customer;
import my.ohremchuk.task8.pojo.single_table.Human;
import my.ohremchuk.task8.pojo.table_perSubclass.ContractEmployee;
import my.ohremchuk.task8.pojo.table_perSubclass.Employee;
import my.ohremchuk.task8.pojo.table_perSubclass.RegularEmployee;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;

@UtilityClass// private constructor, finally class
public class HibernateUtil {
    public static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Company.class);
        configuration.addAttributeConverter(new BirthdayConverter());
        configuration.addAnnotatedClass(Car.class);
        configuration.addAnnotatedClass(AddressBook.class);
        configuration.addAnnotatedClass(Human.class);
        configuration.addAnnotatedClass(Customer.class);
        configuration.addAnnotatedClass(Client.class);
        configuration.addAnnotatedClass(Animal.class);
        configuration.addAnnotatedClass(HomePet.class);
        configuration.addAnnotatedClass(WildPet.class);
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(ContractEmployee.class);
        configuration.addAnnotatedClass(RegularEmployee.class);
        configuration.configure();
        return configuration.buildSessionFactory();
    }
}
