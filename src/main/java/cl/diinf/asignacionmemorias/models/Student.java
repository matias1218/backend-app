package cl.diinf.asignacionmemorias.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "lastname_1", nullable = false)
    private String lastname1;

    @Column(name = "lastname_2")
    private String lastname2;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "year_income", nullable = false)
    private int income;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "program_id", foreignKey = @ForeignKey(name = "programs_student_fk"))
    private Program program;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="thesis_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Thesis thesis;

    public void addProgram(Program program) {
        this.setProgram(program);
        program.getStudents().add(this);
    }

    public void assignThesis(Thesis thesis){
        this.setThesis(thesis);
    }
}
