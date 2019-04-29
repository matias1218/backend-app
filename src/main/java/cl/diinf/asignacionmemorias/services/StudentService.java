package cl.diinf.asignacionmemorias.services;

import cl.diinf.asignacionmemorias.models.Student;
import cl.diinf.asignacionmemorias.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")

public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Student> getStudents(){
        return this.studentRepository.findAll();
    }
}
