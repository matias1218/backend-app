package cl.diinf.asignacionmemorias.repositories;

import cl.diinf.asignacionmemorias.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>{}
