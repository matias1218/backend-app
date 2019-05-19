package cl.diinf.asignacionmemorias.dao;

import cl.diinf.asignacionmemorias.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfessorDAO extends JpaRepository<Professor, Long> {

  //@Query("SELECT t.professors FROM Topic t WHERE t.id = :id")
  //List<Professor> findProfessorsByTopicId(@Param("id") Long id);

  Professor findProfessorById(Long id);

}
