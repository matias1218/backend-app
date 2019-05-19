package cl.diinf.asignacionmemorias.dao;

import cl.diinf.asignacionmemorias.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDAO extends JpaRepository<Student, Long> {
    Student findByNameAndLastname1(String name, String lastname);
    Student findStudentById(Long id);
}
