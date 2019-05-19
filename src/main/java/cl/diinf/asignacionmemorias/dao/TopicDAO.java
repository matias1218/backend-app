package cl.diinf.asignacionmemorias.dao;

import cl.diinf.asignacionmemorias.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicDAO extends JpaRepository<Topic, Long> {
    @Query("SELECT p.topics FROM Professor p WHERE p.id = :id")
    List<Topic> findTopicsByProfessorId(@Param("id") Long id);
}
