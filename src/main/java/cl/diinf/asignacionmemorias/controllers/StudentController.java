package cl.diinf.asignacionmemorias.controllers;

import cl.diinf.asignacionmemorias.dao.StudentDAO;
import cl.diinf.asignacionmemorias.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")

public class StudentController {
    @Autowired
    private StudentDAO studentDAO;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Student> getStudents(){
        return this.studentDAO.findAll();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Student createStudent(@RequestBody Student student) {
        return studentDAO.save(student);
    }
}
