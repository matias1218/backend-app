package cl.diinf.asignacionmemorias.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class StudentSimpleDTO {
    private long id;
    private String name;
    private String lastname;
    private String email;
    private String program;
    private int income;

}
