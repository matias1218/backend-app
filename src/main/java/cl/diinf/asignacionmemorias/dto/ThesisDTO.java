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
    public StudentSimpleDTO student;
    public ProfessorSimpleDTO teacherGuide;
    public ProfessorSimpleDTO teacherCommission1;
    public ProfessorSimpleDTO teacherCommission2;
    public String topic;
}
