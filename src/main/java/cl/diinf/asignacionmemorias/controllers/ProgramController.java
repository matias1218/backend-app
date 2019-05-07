package cl.diinf.asignacionmemorias.controllers;

import cl.diinf.asignacionmemorias.dao.ProgramDAO;
import cl.diinf.asignacionmemorias.models.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/programs")

public class ProgramController {
    @Autowired
    private ProgramDAO programDAO;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Program> getPrograms(){
        return this.programDAO.findAll();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Program createProgram(@RequestBody Program program) {
        return programDAO.save(program);
    }
}
