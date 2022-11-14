package my.ohremchuk.mainTask.util.hibernate;
import lombok.experimental.UtilityClass;

import my.ohremchuk.mainTask.converter.BirthdayConvertor;
import my.ohremchuk.mainTask.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;

@UtilityClass// private constructor, finally class
public class HibernateUtil {

    public static SessionFactory buildSessionFactory(){
        Configuration configuration = new Configuration();
        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
        configuration.addAnnotatedClass(User.class);
        configuration.addAttributeConverter(new BirthdayConvertor());
        configuration.configure();
        return configuration.buildSessionFactory();
    }
}