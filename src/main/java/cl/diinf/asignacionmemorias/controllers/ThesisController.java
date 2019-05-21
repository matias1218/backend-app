package cl.diinf.asignacionmemorias.controllers;

import cl.diinf.asignacionmemorias.dto.NewThesisDTO;
import cl.diinf.asignacionmemorias.dto.ThesisDTO;
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

    @RequestMapping(method = RequestMethod.GET, value = "/guide/{professorId}")
    public ResponseEntity getThesesByProfessorId(@PathVariable Long professorId) {
        try {
            return new ResponseEntity<>(this.thesisService.getThesesByProfessorId(professorId), HttpStatus.OK);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/commission/{professorId}")
    public ResponseEntity getThesesByCommissionProfessorId(@PathVariable Long professorId){
        try {
            return new ResponseEntity<>(this.thesisService.getThesesCommissionId(professorId), HttpStatus.OK);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/topic/{topicId}")
    public ResponseEntity getThesesByTopicId(@PathVariable Long topicId){
        try {
            return new ResponseEntity<>(this.thesisService.getThesesByTopicId(topicId), HttpStatus.OK);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/missing/commission")
    public ResponseEntity getThesesMissingCommission(){
        try {
            return new ResponseEntity<>(this.thesisService.getThesesMissingCommission(), HttpStatus.OK);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/full/commission")
    public ResponseEntity getThesesFullCommission(){
        try {
            return new ResponseEntity<>(this.thesisService.getThesesFullCommission(), HttpStatus.OK);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity createThesis(@RequestBody NewThesisDTO newThesisDTO) {
        try {
            ThesisDTO thesisDTO = this.thesisService.createThesis(newThesisDTO);
            if(thesisDTO != null)
                return new ResponseEntity<>(thesisDTO, HttpStatus.CREATED);
            return new ResponseEntity<>("Thesis cannot be created", HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
