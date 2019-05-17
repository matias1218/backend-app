package cl.diinf.asignacionmemorias.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class StudentDTO {
    private String name;
    private String lastname1;
    private String lastname2;
    private String email;
    private int income;
    private ProgramDTO program;
}
