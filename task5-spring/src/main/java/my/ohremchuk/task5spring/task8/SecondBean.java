package my.ohremchuk.task5spring.task8;

import org.springframework.stereotype.Service;

@Service
public class SecondBean implements AbstractBean{
    @Override
    public void printMessage() {
        System.out.println("second");
    }
}