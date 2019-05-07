package cl.diinf.asignacionmemorias.dao;

import cl.diinf.asignacionmemorias.models.Thesis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThesisDAO extends JpaRepository<Thesis, Long> {
}
