package cl.diinf.asignacionmemorias.controllers;

import cl.diinf.asignacionmemorias.services.ProfessorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/professors")
@Slf4j
public class ProfessorController {
    private final ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity getProfessors() {
        try {
            return new ResponseEntity<>(this.professorService.getAllProfessors(), HttpStatus.OK);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/topic/{topicId}")
    public ResponseEntity getProfessorsByTopicId(@PathVariable Long topicId) {
        try {
            return new ResponseEntity<>(this.professorService.getProffessorsByTopicId(topicId), HttpStatus.OK);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{professorId}")
    public ResponseEntity getProfessorById(@PathVariable Long professorId) {
        try {
            return new ResponseEntity<>(this.professorService.getProfessorDTOById(professorId), HttpStatus.OK);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "{professorId}/putTopic/{topicId}")
    public ResponseEntity putTopic(@PathVariable Long professorId, @PathVariable Long topicId) {
        try {
            return new ResponseEntity<>(this.professorService.putTopic(professorId, topicId), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
