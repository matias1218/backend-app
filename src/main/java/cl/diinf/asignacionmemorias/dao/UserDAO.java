package cl.diinf.asignacionmemorias.dao;

import cl.diinf.asignacionmemorias.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
}
