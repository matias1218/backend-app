package cl.diinf.asignacionmemorias.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class TopicDataDTO {
    private Long id;
    private String name;
    private List<ThesisDTO> theses;
    private List<ProfessorSimpleDTO> professors;
}
