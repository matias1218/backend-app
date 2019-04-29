package cl.diinf.asignacionmemorias.repositories;

import cl.diinf.asignacionmemorias.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {}