package cl.diinf.asignacionmemorias.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ThesisSimpleDTO {
    private Long id;
    private String title;
    private String description;
    private StudentSimpleDTO student;
    private String topic;
}
