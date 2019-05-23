package cl.diinf.asignacionmemorias.dao;

import cl.diinf.asignacionmemorias.models.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserDAOTest {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserDAO userDAO;

    @Test
    public void findByEmailAndPassword() {

        User user = new User();
        user.setName("testUserName");
        user.setLastname("testUserLastName");
        user.setEmail("test@gmail.com");
        user.setPassword("testPassword");
        entityManager.persist(user);

        Optional<User> found = userDAO.findByEmailAndPassword("test@gmail.com", "testPassword");
        assertEquals("testUserName", found.get().getName());

    }

    @Test
    public void findByEmail() {

        User user = new User();
        user.setName("testUserName");
        user.setLastname("testUserLastName");
        user.setEmail("test@gmail.com");
        user.setPassword("testPassword");
        entityManager.persist(user);

        Optional<User> found = userDAO.findByEmail("test@gmail.com");
        assertEquals("testUserName", found.get().getName());

    }

    @Test
    public void existsByEmail() {

        User user = new User();
        user.setName("testUserName");
        user.setLastname("testUserLastName");
        user.setEmail("test@gmail.com");
        user.setPassword("testPassword");
        entityManager.persist(user);

        //Optional<User> found = userDAO.existsByEmail("email");
        assertEquals(userDAO.existsByEmail("test@gmail.com"), true);

    }
}