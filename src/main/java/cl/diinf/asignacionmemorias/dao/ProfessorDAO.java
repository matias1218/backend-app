package cl.diinf.asignacionmemorias.dao;

import cl.diinf.asignacionmemorias.models.Professor;
import cl.diinf.asignacionmemorias.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface ProfessorDAO extends JpaRepository<Professor, Long> {

  @Query("SELECT p.topics FROM Professor p WHERE p.id = :id")
  Set<Topic> getTopicsByProfessor(@Param("id") Long id);
}
