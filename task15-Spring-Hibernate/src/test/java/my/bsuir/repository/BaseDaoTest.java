package my.bsuir.repository;
import lombok.Data;
import lombok.SneakyThrows;
import my.bsuir.DataConfig;
import my.bsuir.MysqlJdbcDataSource;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.ext.mysql.MySqlConnection;
import org.junit.BeforeClass;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource(value = "classpath:/app_test.properties")
@ContextConfiguration(classes = DataConfig.class)
public class BaseDaoTest {

    // JDBC data source
    static MysqlJdbcDataSource testMysqlJdbcDataSource;
    // DBUnit connection
    static IDatabaseConnection iDatabaseConnection;

    @BeforeClass
    @SneakyThrows
    public static void init() {
        testMysqlJdbcDataSource = new MysqlJdbcDataSource("app_test.properties");
        iDatabaseConnection = new MySqlConnection(testMysqlJdbcDataSource.getConnection(), "facility_test");
    }
}