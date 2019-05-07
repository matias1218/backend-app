package cl.diinf.asignacionmemorias.controllers;

import cl.diinf.asignacionmemorias.dao.TeacherDAO;
import cl.diinf.asignacionmemorias.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/teachers")

public class TeacherController {
    @Autowired
    private TeacherDAO teacherDAO;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Teacher> getTeachers(){
        return this.teacherDAO.findAll();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherDAO.save(teacher);
    }
}
