package cl.diinf.asignacionmemorias.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "theses")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Thesis {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToOne(fetch=FetchType.LAZY, mappedBy = "thesis", cascade = CascadeType.ALL, optional = false)
    private Student student;

    @ManyToOne(optional = false)
    @JoinColumn(name = "topic_id", foreignKey = @ForeignKey(name = "thesis_topics_fk"))
    private Topic topic;

    @OneToMany(mappedBy = "thesis")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Tracking> tracking = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "professor_guide_id", updatable = false, nullable = false, foreignKey = @ForeignKey(name = "thesis_guide_fk"))
    private Professor guide;

    @ManyToOne
    @JoinColumn(name = "professor_c1_id", updatable = true, nullable = true, foreignKey = @ForeignKey(name = "thesis_commisionfirst_fk"))
    private Professor commissionFirst;

    @ManyToOne
    @JoinColumn(name = "professor_c2_id", updatable = true, nullable = true, foreignKey = @ForeignKey(name = "thesis_commissionsecond_fk"))
    private Professor commissionSecond;
}
