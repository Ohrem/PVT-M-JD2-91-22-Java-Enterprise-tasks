package my.ohremchuk.task5spring.task2;
import org.springframework.beans.factory.DisposableBean;

public class FactoryMethodBean implements DisposableBean {
    public CreatedBean createBean() {
        return new CreatedBean();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy for factory");
    }
}
