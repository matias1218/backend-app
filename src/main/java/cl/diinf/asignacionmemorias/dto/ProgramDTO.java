package cl.diinf.asignacionmemorias.dto;

import cl.diinf.asignacionmemorias.models.Student;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;


@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ProgramDTO {
    private String name;
    private int code;
    private Set<Student> students;
}
