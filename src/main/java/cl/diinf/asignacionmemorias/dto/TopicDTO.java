package cl.diinf.asignacionmemorias.dto;

import cl.diinf.asignacionmemorias.models.Teacher;
import cl.diinf.asignacionmemorias.models.Thesis;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class TopicDTO {
    private String name;
    private Set<TeacherDTO> teachers;
    private Set<ThesisDTO> theses;
}
