package cl.diinf.asignacionmemorias.repositories;

import cl.diinf.asignacionmemorias.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic,Integer> {}