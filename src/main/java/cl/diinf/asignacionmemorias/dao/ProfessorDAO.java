package cl.diinf.asignacionmemorias.dao;

import cl.diinf.asignacionmemorias.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorDAO extends JpaRepository<Professor, Long> {
}
