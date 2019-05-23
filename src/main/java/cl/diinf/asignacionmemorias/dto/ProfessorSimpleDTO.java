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
public class ProfessorSimpleDTO {
    private long id;
    private String name;
    private String email;
    private boolean academic;
    private String imageUrl;
    private List<ThesisSimpleDTO> commissions;
}
