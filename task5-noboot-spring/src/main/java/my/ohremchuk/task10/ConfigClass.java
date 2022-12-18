package my.ohremchuk.task10;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {"my.ohremchuk"}, includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
        classes = FilterAnnotation.class))
public class ConfigClass {
}