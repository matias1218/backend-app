package cl.diinf.asignacionmemorias.controllers;

import cl.diinf.asignacionmemorias.services.ProfessorService;
import cl.diinf.asignacionmemorias.services.ThesisService;
import cl.diinf.asignacionmemorias.services.TopicService;
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
    private final ThesisService thesisService;
    private final TopicService topicService;

    @Autowired
    public ProfessorController(ProfessorService professorService, ThesisService thesisService, TopicService topicService) {
        this.professorService = professorService;
        this.thesisService = thesisService;
        this.topicService = topicService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity getStudents() {
        try {
            return new ResponseEntity<>(professorService.getAll(), HttpStatus.OK);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /*@RequestMapping(value = "/{professorId}/topics", method = RequestMethod.GET )
    @ResponseBody
    public ResponseEntity getTopicsByProfessor(@PathVariable Long professorId){
        try {
            return new ResponseEntity<>(this.topicService.getByProfessorId(professorId), HttpStatus.OK);
        }
        catch (Exception e)
        {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /*@RequestMapping(value = "/{professorId}/theses", method = RequestMethod.GET )
    @ResponseBody
    public ResponseEntity getThesesByProfessor(@PathVariable Long professorId)
    {
        try {
            return new ResponseEntity<>(this.thesisService.getByProfessorId(professorId), HttpStatus.OK);
        }
        catch (Exception e)
        {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }*/
}
