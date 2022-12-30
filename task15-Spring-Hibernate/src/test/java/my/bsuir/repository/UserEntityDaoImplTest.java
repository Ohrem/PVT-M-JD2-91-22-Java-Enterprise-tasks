package my.bsuir.repository;

import lombok.SneakyThrows;
import my.bsuir.model.UserEntity;
import my.bsuir.model.UserRole;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)

public class UserEntityDaoImplTest extends BaseDaoTest {

    @Autowired
    UserEntityDao targetObject;

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
        targetObject = null;
    }

    @Test
    @SneakyThrows
    public void create() {
        //Given
        Connection conn = testMysqlJdbcDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery("select count(*) from user;");
        rs.next();
        int initialSize = rs.getInt(1);
        assertEquals(0, initialSize);

        UserEntity user = UserEntity.builder()
                .name("Alex")
                .surname("Ohremchuk")
                .email("ohrem25032002@gmail.com")
                .password("1111")
                .phone("+375447714261")
                .role(UserRole.ADMIN)
                .balance(BigDecimal.valueOf(100.13))
                .build();

        //When
        targetObject.create(user);

        //Then
        rs = conn.createStatement().executeQuery("select count(*) from user;");
        rs.next();
        int actualSize = rs.getInt(1);
        assertEquals(1, actualSize);
        conn.createStatement().executeUpdate("SET FOREIGN_KEY_CHECKS = 0;");
        conn.createStatement().executeUpdate("truncate table user;");
        conn.createStatement().executeUpdate("SET FOREIGN_KEY_CHECKS = 1;");
        conn.close();
    }

    @Test
    @SneakyThrows
    public void findById() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(UserEntityDaoImplTest.class.getResourceAsStream("UserDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        UserEntity user = targetObject.findById(101);

        //Then
        assertEquals("Roman", user.getName());
        assertEquals("Ohremchuk", user.getSurname());
        assertEquals("ohrem25032002@gmail.com", user.getEmail());
        assertEquals("1111", user.getPassword());
        assertEquals("+375447714261", user.getPhone());
        assertEquals(BigDecimal.valueOf(1000), user.getBalance());
        assertEquals(UserRole.ADMIN, user.getRole());

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }

    @Test
    @SneakyThrows
    public void update() {
        //Given
        Connection conn = testMysqlJdbcDataSource.getConnection();
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(UserEntityDaoImplTest.class.getResourceAsStream("UserDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        ResultSet rs = conn.createStatement().executeQuery("select count(*) from user;");
        rs.next();
        int initialSize = rs.getInt(1);
        assertEquals(3, initialSize);

        //When
        UserEntity user = targetObject.findById(101);
        assertNotNull(user);

        UserEntity updatedUser = UserEntity.builder()
                .id(101L)
                .name("Anton")
                .surname("Zander")
                .email("antosha@gmail.com")
                .password("1111")
                .phone("123456789")
                .balance(BigDecimal.valueOf(1500))
                .role(UserRole.USER)
                .build();

        targetObject.update(updatedUser);

        assertEquals("Anton", updatedUser.getName());
        assertEquals("Zander", updatedUser.getSurname());
        assertEquals("antosha@gmail.com", updatedUser.getEmail());
        assertEquals("1111", updatedUser.getPassword());
        assertEquals("123456789", updatedUser.getPhone());
        assertEquals(BigDecimal.valueOf(1500), updatedUser.getBalance());
        assertEquals(UserRole.USER, updatedUser.getRole());

        //Then
        rs = conn.createStatement().executeQuery("select count(*) from user;");
        rs.next();
        int actualSize = rs.getInt(1);
        assertEquals(3, actualSize);
        conn.createStatement().executeUpdate("SET FOREIGN_KEY_CHECKS = 0;");
        conn.createStatement().executeUpdate("truncate table user;");
        conn.createStatement().executeUpdate("SET FOREIGN_KEY_CHECKS = 1;");
        conn.close();

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }


    @Test
    @SneakyThrows
    public void delete() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(UserEntityDaoImplTest.class.getResourceAsStream("UserDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        UserEntity user = targetObject.findById(101);
        assertNotNull(user);
        targetObject.delete(user);

        //Then
        Connection conn = testMysqlJdbcDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery("select count(*) from user;");
        rs.next();
        int actualSize = rs.getInt(1);
        assertEquals(2, actualSize);

        conn.createStatement().executeUpdate("SET FOREIGN_KEY_CHECKS = 0;");
        conn.createStatement().executeUpdate("truncate table user;");
        conn.createStatement().executeUpdate("SET FOREIGN_KEY_CHECKS = 1;");
        conn.close();

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }

    @Test
    @SneakyThrows
    public void findAll() {
        //Given
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(UserEntityDaoImplTest.class.getResourceAsStream("UserDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        List<UserEntity> users = targetObject.findAll();

        //Then
        assertEquals(users.size(), 3);
        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
    }
}