package my.ohremchuk.task5spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class Task5SpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(Task5SpringApplication.class, args);
    }

}
