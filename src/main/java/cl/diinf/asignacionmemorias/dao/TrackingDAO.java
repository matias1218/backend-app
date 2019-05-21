package cl.diinf.asignacionmemorias.dao;

import cl.diinf.asignacionmemorias.models.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackingDAO extends JpaRepository<Tracking, Long> {
}
