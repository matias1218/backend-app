package cl.diinf.asignacionmemorias.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ThesisDTO {
    public String title;
    public String description;
    public StudentDTO studentDTO;
    public ProfessorDTO teacherGuide;
    public ProfessorDTO teacherCommission1;
    public ProfessorDTO teacherCommission2;
    public String topic;
}
