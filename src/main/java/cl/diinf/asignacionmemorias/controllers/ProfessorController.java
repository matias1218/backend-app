package cl.diinf.asignacionmemorias.controllers;

import cl.diinf.asignacionmemorias.dao.ProfessorDAO;
import cl.diinf.asignacionmemorias.models.Professor;
import cl.diinf.asignacionmemorias.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/professors")

public class ProfessorController {
    @Autowired
    private ProfessorDAO professorDAO;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Professor> getProfessors(){
        return this.professorDAO.findAll();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Professor createProfessor(@RequestBody Professor professor) {
        return professorDAO.save(professor);
    }

      @CrossOrigin
    @RequestMapping(value = "/{professorId}/topics", method = RequestMethod.GET )
    @ResponseBody
    public Set<Topic> getTopicsByProfessor(@PathVariable  Long professorId){

        return this.professorDAO.getTopicsByProfessor(professorId);
    }

}
