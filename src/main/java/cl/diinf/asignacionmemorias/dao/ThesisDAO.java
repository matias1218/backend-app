package cl.diinf.asignacionmemorias.dto;

import cl.diinf.asignacionmemorias.models.Thesis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThesisDAO extends JpaRepository<Thesis, Long> {
}
