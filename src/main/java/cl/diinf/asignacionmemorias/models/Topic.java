package cl.diinf.asignacionmemorias.models;

import javax.persistence.*;

@Entity
@Table(name = "topics")
public class Topic {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
