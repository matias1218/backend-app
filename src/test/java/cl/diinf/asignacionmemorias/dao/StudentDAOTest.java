package cl.diinf.asignacionmemorias.dao;

import cl.diinf.asignacionmemorias.models.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentDAOTest {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StudentDAO studentDAO;

    @Test
    public void findByCode() {

        Student student = new Student();
        student.setName("testName");
        student.setLastname1("testLastName");
        student.setEmail("test@gmail.com");

        entityManager.persist(student);

        Student found = studentDAO.findByNameAndLastname1("testName", "testLastName");
        assertEquals("test@gmail.com", found.getEmail());

    }
}