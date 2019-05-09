package cl.diinf.asignacionmemorias.dto;

import cl.diinf.asignacionmemorias.models.Tracking;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ThesisDTO {
    private String title;
    private String description;
    private TeacherDTO guide;
    private TopicDTO topic;
    private StudentDTO student;
    private Set<Tracking> tracking;
}
