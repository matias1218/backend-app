package cl.diinf.asignacionmemorias.services;

import cl.diinf.asignacionmemorias.models.Teacher;
import cl.diinf.asignacionmemorias.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/teachers")

public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Teacher> getTeachers(){
        return this.teacherRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherRepository.save(teacher);
    }
}
