package cl.diinf.asignacionmemorias.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    @ManyToOne(optional = false)
    @JoinColumn(name = "program_id", foreignKey = @ForeignKey(name = "programs_user_fk"))
    private Program program;
}
