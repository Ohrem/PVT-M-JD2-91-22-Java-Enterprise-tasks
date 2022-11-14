//package my.ohremchuk.mainTask.dao;
//
//import lombok.SneakyThrows;
//import my.ohremchuk.mainTask.entity.BirthDay;
//import my.ohremchuk.mainTask.entity.PersonalInfo;
//import my.ohremchuk.mainTask.entity.Role;
//import my.ohremchuk.mainTask.entity.User;
//import my.ohremchuk.mainTask.util.jdbc.ConnectionManager;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import javax.persistence.Column;
//import javax.persistence.Table;
//import java.lang.reflect.Field;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.time.LocalDate;
//import java.util.Arrays;
//
//import static java.util.Optional.ofNullable;
//import static java.util.stream.Collectors.joining;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//public class TestDao {
//    UserDaoImpl targetObject;
//
//    @Before
//    public void setUp() {
//        targetObject = new UserDaoImpl();
//    }
//
//    @After
//    public void tearDown() {
//        targetObject = null;
//    }
//
//
//    @Test
//    @SneakyThrows
//    public void findById() {
//        User user = targetObject.findById(12L);
//        //Then
//        assertEquals("egorMilik@gmail.com", user.getPersonalInfo().getUserEmail());
//        assertEquals("Egorka", user.getPersonalInfo().getFirstname());
//        assertEquals("Peela", user.getPersonalInfo().getLastname());
//        assertEquals("DEVELOPER", user.getRole().toString());
//    }
//
//    @Test
//    @SneakyThrows
//    public void delete() {
//        //Given
//        Connection conn = ConnectionManager.get();
//        ResultSet rs = conn.createStatement().executeQuery("select count(*) FROM users;");
//        rs.next();
//        int size = rs.getInt(1);
//        User user = targetObject.findById(13);
//        assertNotNull(user);
//        //Then
//        targetObject.delete(user);
//
////Then
//        rs = conn.createStatement().executeQuery("select count(*) from users;");
//        rs.next();
//        int actualSize = rs.getInt(1);
//        assertEquals(--size, actualSize);
//        conn.close();
//    }
//
//    @Test
//    @SneakyThrows
//    public void create() {
//        //Given
//        Connection conn = ConnectionManager.get();
//        ResultSet rs = conn.createStatement().executeQuery("select count(*) from users;");
//        rs.next();
//        int initialSize = rs.getInt(1);
//        User user = User.builder()
//                .personalInfo(PersonalInfo.builder().firstname("Timofeyt")
//                        .lastname("Liskoveyt").birthDate(new BirthDay(LocalDate.of(1981, 6, 20)))
//                        .userEmail("TimoshaTankt@gmail.com")
//                        .build())
//                .role(Role.USER)
//                .build();
//        //When
//        targetObject.create(user);
//
//        //Then
//        rs = conn.createStatement().executeQuery("select count(*) from users;");
//        rs.next();
//        int actualSize = rs.getInt(1);
//        assertEquals(++initialSize, actualSize);
//        conn.close();
//    }
//
//    @Test
//    @SneakyThrows
//    public void update() {
//        Connection conn = ConnectionManager.get();
//        ResultSet rs = conn.createStatement().executeQuery("select count(*) from users;");
//        rs.next();
//        int initialSize = rs.getInt(1);
//        User user = User.builder()
//                .id(11L)
//                .personalInfo(PersonalInfo.builder().firstname("Dasha")
//                        .lastname("Kisel").birthDate(new BirthDay(LocalDate.of(2001, 11, 21)))
//                        .userEmail("Dasha@gmail.com")
//                        .build())
//                .role(Role.ADMIN)
//                .build();
//        //When
//        targetObject.update(user);
//        User user1 = targetObject.findById(11);
//        assertEquals("Dasha", user.getPersonalInfo().getFirstname());
//        assertEquals("Kisel", user.getPersonalInfo().getLastname());
//        assertEquals("Dasha@gmail.com", user.getPersonalInfo().getUserEmail());
//        assertEquals("ADMIN", user.getRole().toString());
//        assertEquals("20", user.getPersonalInfo().getBirthDate().getAge().toString());
//    }
//
//
//    @Test
//    public void checkReflectionApi() throws SQLException, IllegalAccessException {
//
//        User user = User.builder()
//                .build();
//
//        String sql = """
//                insert
//                into
//                %s
//                (%s)
//                values
//                (%s)
//                """;
//        String tableName = ofNullable(user.getClass().getAnnotation(Table.class))
//                .map(tableAnnotation -> tableAnnotation.schema() + "." + tableAnnotation.name())
//                .orElse(user.getClass().getName());
//
//        Field[] declaredFields = user.getClass().getDeclaredFields();
//
//        String columnNames = Arrays.stream(declaredFields)
//                .map(field -> ofNullable(field.getAnnotation(Column.class))
//                        .map(Column::name)
//                        .orElse(field.getName()))
//                .collect(joining(", "));
//
//        String columnValues = Arrays.stream(declaredFields)
//                .map(field -> "?")
//                .collect(joining(", "));
//
//        System.out.println(sql.formatted(tableName, columnNames, columnValues));
//        Connection connection = ConnectionManager.get();
//        PreparedStatement preparedStatement = connection.prepareStatement(sql.formatted(tableName, columnNames, columnValues));
//        for (Field declaredField : declaredFields) {
//            declaredField.setAccessible(true);
//            preparedStatement.setObject(1, declaredField.get(user));
//        }
//    }
//}
