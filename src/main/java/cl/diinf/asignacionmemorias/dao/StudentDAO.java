package cl.diinf.asignacionmemorias.dao;


import cl.diinf.asignacionmemorias.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentDAO extends JpaRepository<Student, Long> {
    Optional<Student> findByNameAndLastname1(String name, String lastname);
}
