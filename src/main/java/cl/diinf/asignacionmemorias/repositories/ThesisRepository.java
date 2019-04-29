package cl.diinf.asignacionmemorias.repositories;

import cl.diinf.asignacionmemorias.models.Thesis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThesisRepository extends JpaRepository<Thesis,Integer> {}