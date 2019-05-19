package cl.diinf.asignacionmemorias.dao;

import cl.diinf.asignacionmemorias.models.Thesis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ThesisDAO extends JpaRepository<Thesis, Long> {
    @Query("SELECT p.theses FROM Professor p WHERE p.id = :id")
    List<Thesis> findThesesByProfessorId(@Param("id") Long id);


    @Query("SELECT p.commision1 FROM Professor p WHERE p.id = :id")
    List<Thesis> findThesesByCommission1(@Param("id") Long id);

    @Query("SELECT p.commision2 FROM Professor p WHERE p.id = :id")
    List<Thesis> findThesesByCommission2(@Param("id") Long id);
}
