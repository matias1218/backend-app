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
public class TeacherDTO {
    private String name;
    private String lastname1;
    private String lastname2;
    private String email;
    private boolean academic;
    private Set<TopicDTO> specialties;
    private Set<ThesisDTO> theses;
    private Set<StudentDTO> students;
}
