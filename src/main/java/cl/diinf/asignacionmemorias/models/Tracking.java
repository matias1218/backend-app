package cl.diinf.asignacionmemorias.models;

import cl.diinf.asignacionmemorias.util.Status;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tracking")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Tracking {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "timestamp", updatable = false)
    protected ZonedDateTime creationDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "observation")
    private String observation;

    @ManyToOne
    @JoinColumn(name = "thesis_id", foreignKey = @ForeignKey(name = "tracking_theses_fk"))
    private Thesis thesis;

    @ManyToMany(fetch=FetchType.LAZY,  mappedBy = "trackings")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<User> users = new HashSet<>();
}
