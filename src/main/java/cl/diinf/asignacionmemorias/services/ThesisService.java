package cl.diinf.asignacionmemorias.services;

import cl.diinf.asignacionmemorias.models.Thesis;
import cl.diinf.asignacionmemorias.repositories.ThesisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/theses")   // (asi se dice el plural de tesis en ingles xd)

public class ThesisService {
    @Autowired
    private ThesisRepository thesisRepository;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Thesis> getTeachers(){
        return this.thesisRepository.findAll();
    }
}
