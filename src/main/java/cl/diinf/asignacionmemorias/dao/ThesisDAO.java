package cl.diinf.asignacionmemorias.dao;

import cl.diinf.asignacionmemorias.models.Professor;
import cl.diinf.asignacionmemorias.models.Thesis;
import cl.diinf.asignacionmemorias.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThesisDAO extends JpaRepository<Thesis, Long> {
    List<Thesis> findByGuide(Professor professor);
    List<Thesis> findByGuide_NameAndGuide_Lastname1(String name, String lastname);
    List<Thesis> findByTopic(Topic topic);
    List<Thesis> findByTopic_Name(String name);
}
