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
@Table(name = "topics")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Topic {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(name = "professor_topics",
            joinColumns = @JoinColumn(name = "topic_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "professor_id", referencedColumnName = "id"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Professor> professors = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "topic")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Thesis> theses;
}
