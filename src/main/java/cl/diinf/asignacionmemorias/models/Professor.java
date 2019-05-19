package cl.diinf.asignacionmemorias.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
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
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Topic> topics = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "guide")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Thesis> theses = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "commissionFirst")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Thesis> commision1 = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "commissionSecond")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Thesis> commision2 = new HashSet<>();

    /*
    private Set<Thesis> incorrection;

    private Set<Thesis> corrected;*/

}
