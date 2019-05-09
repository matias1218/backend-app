package cl.diinf.asignacionmemorias.dto;

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
    private Set<StudentDTO> students;
}
