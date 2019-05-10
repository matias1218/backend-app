package cl.diinf.asignacionmemorias.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "professors")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Professor {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "lastname_1", nullable = false)
    private String lastname1;

    @Column(name = "lastname_2")
    private String lastname2;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "academic", nullable = false)
    private boolean academic;


    @ManyToMany(fetch=FetchType.LAZY,  mappedBy = "professors")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
    private List<Topic> topics = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "guide")
    private Set<Thesis> theses;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "program")
    private Set<Student> students;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "firstProfessor")
    private Set<Commission> commissions;




    /*
    private Set<Thesis> incorrection;

    private Set<Thesis> corrected;*/

}
