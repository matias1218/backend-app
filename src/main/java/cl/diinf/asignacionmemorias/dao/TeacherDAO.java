package cl.diinf.asignacionmemorias.dto;

import cl.diinf.asignacionmemorias.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherDAO extends JpaRepository<Teacher, Long> {
}
