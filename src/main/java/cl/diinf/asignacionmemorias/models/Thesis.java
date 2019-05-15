package cl.diinf.asignacionmemorias.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "theses")
@Getter
@Setter
@ToString

public class Thesis {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "professor_id", foreignKey = @ForeignKey(name = "thesis_professors_fk"))
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
    private Professor guide;

    @ManyToOne(optional = false)
    @JoinColumn(name = "topic_id", foreignKey = @ForeignKey(name = "thesis_topics_fk"))
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
    private Topic topic;

    @OneToOne(fetch=FetchType.LAZY, mappedBy = "thesis")
    private Student student;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "thesis")
    private Set<Tracking> tracking;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="commission_id", nullable = true)
    private Commission commission;

}
