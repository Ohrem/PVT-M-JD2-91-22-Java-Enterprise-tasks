package my.ohremchuk.task5spring;

import my.ohremchuk.task5spring.task2.CreatedBean;
import my.ohremchuk.task5spring.task8.AbstractBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
//task 2, 8, 9 test
@SpringBootTest
@ImportResource("classpath:beans.xml")
class Task5SpringApplicationTests {
    @Autowired
    @Qualifier("firstBean")
    public AbstractBean firstBean;

    @Autowired
    @Qualifier("secondBean")
    public AbstractBean secondBean;

    @Autowired
    public CreatedBean createdBean;

    @Test
    void contextLoads() {
    }

    @Test
    public void testPrintMessage() {
        firstBean.printMessage();
        secondBean.printMessage();
        assertNotNull(createdBean);
    }
}
