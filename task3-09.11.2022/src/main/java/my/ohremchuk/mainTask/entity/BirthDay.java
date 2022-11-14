package my.ohremchuk.mainTask.entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public record BirthDay(LocalDate birthDate) {
    public Long getAge() {
        return ChronoUnit.YEARS.between(birthDate, LocalDate.now());
    }
}