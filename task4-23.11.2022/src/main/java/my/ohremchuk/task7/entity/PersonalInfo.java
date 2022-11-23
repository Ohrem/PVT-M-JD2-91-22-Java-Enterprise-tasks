package my.ohremchuk.task7.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class PersonalInfo implements Serializable {

    @Serial
    private static final int serialVersionUID = 1;

    private String firstname;
    private String lastname;

    //    @Convert(converter = BirthdayConverter.class)
    private Birthday birthDate;
}
