package cl.diinf.asignacionmemorias.controllers;

import cl.diinf.asignacionmemorias.dao.ThesisDAO;
import cl.diinf.asignacionmemorias.models.Thesis;
import cl.diinf.asignacionmemorias.services.ThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value = "/theses")
@CrossOrigin
public class ThesisController {
    private final ThesisService thesisService;

    @Autowired
    public ThesisController(ThesisService thesisService) {
        this.thesisService = thesisService;
    }

    /*@RequestMapping(method = RequestMethod.GET, path = "{thesisId}/assign/{professorId}")
    @ResponseBody
    public ResponseEntity assignToProfessor(@PathVariable Long thesisId, @PathVariable Long professorId) {
        if(this.thesisService) {

        }

    }*/

    /*@Autowired
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
        return thesisDAO.save(thesis);*/
}
