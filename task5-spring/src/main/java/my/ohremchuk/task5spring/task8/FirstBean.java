package my.ohremchuk.task5spring.task8;
import org.springframework.stereotype.Service;

@Service
public class FirstBean implements AbstractBean{
    @Override
    public void printMessage() {
        System.out.println("first");
    }
}

