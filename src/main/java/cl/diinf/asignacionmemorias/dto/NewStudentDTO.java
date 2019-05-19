package cl.diinf.asignacionmemorias.dto;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@NoArgsConstructor
public class NewStudentDTO {
    @NonNull private String name;
    @NonNull private String lastname1;
    @NonNull private String lastname2;
    private int income;
    private String email;
    private int codeProgram;
}
