package cl.diinf.asignacionmemorias.controllers;

import cl.diinf.asignacionmemorias.services.ThesisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping(value = "/theses")   // (asi se dice el plural de tesis en ingles xd)
@Slf4j
public class ThesisController {

    private ThesisService thesisService;

    @Autowired
    public ThesisController(ThesisService thesisService) {
        this.thesisService = thesisService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity getTheses() {
        try {
            return new ResponseEntity<>(this.thesisService.getAllTheses(), HttpStatus.OK);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
