package cl.diinf.asignacionmemorias.controllers;

import cl.diinf.asignacionmemorias.dao.ThesisDAO;
import cl.diinf.asignacionmemorias.models.Thesis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/theses")   // (asi se dice el plural de tesis en ingles xd)

public class ThesisController {
    @Autowired
    private ThesisDAO thesisDAO;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Thesis> getProfessors(){
        return this.thesisDAO.findAll();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Thesis createThesis(@RequestBody Thesis thesis) {
        return thesisDAO.save(thesis);
    }
}
