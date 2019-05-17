package cl.diinf.asignacionmemorias.dao;

import cl.diinf.asignacionmemorias.models.Program;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramDAO extends JpaRepository<Program, Long> {
    Program getProgramByCode(int code);
}
