package cl.diinf.asignacionmemorias.dao;

import cl.diinf.asignacionmemorias.models.Professor;
import cl.diinf.asignacionmemorias.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface TopicDAO extends JpaRepository<Topic, Long> {

    @Query("SELECT t.professors FROM Topic t WHERE t.id = :id")
    Set<Professor> getProfessorsByTopic(@Param("id") Long id);
}
