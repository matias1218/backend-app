package cl.diinf.asignacionmemorias.controllers;

import cl.diinf.asignacionmemorias.services.ThesisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/theses")
@CrossOrigin
@Slf4j
public class ThesisController {
    private final ThesisService thesisService;

    @Autowired
    public ThesisController(ThesisService thesisService) {
        this.thesisService = thesisService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{thesisId}/assign/{professorId}")
    public void assignToProfessor(@PathVariable Long thesisId, @PathVariable Long professorId) {
        log.error("klñkljj" + thesisId + professorId);
        boolean a = this.thesisService.assignComission(professorId, thesisId);
        /*try {
            if(this.thesisService.assignComission((long)professorId, (long)thesisId)) {
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
            return new ResponseEntity<>(false, HttpStatus.CONFLICT);
        }
        catch (Exception e)
        {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }*/
    }
}
