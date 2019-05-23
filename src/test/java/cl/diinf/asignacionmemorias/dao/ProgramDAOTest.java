package cl.diinf.asignacionmemorias.dao;

import cl.diinf.asignacionmemorias.models.Program;
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
public class ProgramDAOTest {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProgramDAO programDAO;

    @Test
    public void findByCode() {

        Program program = new Program();
        program.setName("testName");
        program.setCode(500);
        entityManager.persist(program);

        Optional<Program> found = programDAO.findByCode(500);
        assertEquals("testName", found.get().getName());

    }
}