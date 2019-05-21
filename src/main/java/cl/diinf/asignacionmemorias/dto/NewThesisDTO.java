package cl.diinf.asignacionmemorias.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class NewThesisDTO {
    private String title;
    private String description;
    private Long studentId;
    private Long guideId;
    private Long topicId;
}
