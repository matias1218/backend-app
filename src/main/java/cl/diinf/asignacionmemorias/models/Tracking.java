package cl.diinf.asignacionmemorias.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.ZonedDateTime;

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
    private int status;

    @Column(name = "observation")
    private String observation;

    @ManyToOne
    @JoinColumn(name = "thesis_id", foreignKey = @ForeignKey(name = "tracking_theses_fk"))
    private Thesis thesis;
}
