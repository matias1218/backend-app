package cl.diinf.asignacionmemorias.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "thesis_types")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ThesisType {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "commissionSecond")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Thesis> thesis = new HashSet<>();
}
