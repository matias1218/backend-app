package cl.diinf.asignacionmemorias.services;

import cl.diinf.asignacionmemorias.models.Program;
import cl.diinf.asignacionmemorias.repositories.ProgramRepository;
import cl.diinf.asignacionmemorias.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/programs")

public class ProgramService {
    @Autowired
    private ProgramRepository programRepository;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Program> getPrograms(){
        return this.programRepository.findAll();
    }
}
