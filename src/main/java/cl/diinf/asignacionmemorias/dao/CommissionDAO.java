package cl.diinf.asignacionmemorias.dao;

import cl.diinf.asignacionmemorias.models.Commission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommissionDAO extends JpaRepository<Commission, Long> {
}
