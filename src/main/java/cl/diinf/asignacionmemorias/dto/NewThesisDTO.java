package cl.diinf.asignacionmemorias.dto;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@NoArgsConstructor
public class NewThesisDTO {
    private String title;
    private String description;
    private Long topicId;
    private Long teacherId;
    private Long studentId;
}
