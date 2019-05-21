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
public class ProfessorDTO {
    private Long id;
    private String name;
    private String lastname1;
    private String lastname2;
    private String email;
    private boolean academic;
    private List<TopicDTO> topics;
}