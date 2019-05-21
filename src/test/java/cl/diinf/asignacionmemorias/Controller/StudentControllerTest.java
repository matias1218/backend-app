package cl.diinf.asignacionmemorias.Controller;

import cl.diinf.asignacionmemorias.controllers.StudentController;
import cl.diinf.asignacionmemorias.models.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;

import java.util.Collections;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private StudentController studentController;

    @Test
    public void getAll() throws Exception {
        Student student = new Student();
        student.setEmail("test@test.cl");
        student.setName("test");
        student.setLastname1("test");
        student.setLastname2("test");
        student.setIncome(2015);
        student.setId(1L);

        ResponseEntity<List<Student>> allStudents = new ResponseEntity<>(Collections.singletonList(student), HttpStatus.OK);

        given(studentController.getStudents()).willReturn(allStudents);
        System.out.println(allStudents);

        mvc.perform(get("http://localhost:9090/students/all")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(student.getName())));
        System.out.println("Test success");
    }
}
