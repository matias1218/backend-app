package cl.diinf.asignacionmemorias.repositories;

import cl.diinf.asignacionmemorias.models.Program;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramRepository extends JpaRepository<Program,Integer> {}