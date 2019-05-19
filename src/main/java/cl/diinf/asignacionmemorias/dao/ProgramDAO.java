package cl.diinf.asignacionmemorias.dao;

import cl.diinf.asignacionmemorias.models.Program;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProgramDAO extends JpaRepository<Program, Long> {
    Program getProgramByCode(int code);

    Optional<Program> findByCode(int code);
}
