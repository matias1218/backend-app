package cl.diinf.asignacionmemorias.models;

import javax.persistence.*;

@Entity
@Table(name = "theses")
public class Thesis {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
