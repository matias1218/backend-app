package cl.diinf.asignacionmemorias.dto;

import cl.diinf.asignacionmemorias.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicDAO extends JpaRepository<Topic, Long> {
}
