import my.ohremchuk.task10.ConfigClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void shouldAnswerWithTrue() {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ConfigClass.class);

        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            if ("defaultBean".equals(beanDefinitionName))
                System.out.println(beanDefinitionName);
        }
    }
}