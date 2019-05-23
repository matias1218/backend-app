package cl.diinf.asignacionmemorias.controllers;

import cl.diinf.asignacionmemorias.services.TopicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/topics")
@Slf4j
public class TopicController {
    private TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity getTopics() {
        try {
            return new ResponseEntity<>(this.topicService.getAllTopics(), HttpStatus.OK);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/professor/{professorId}")
    public ResponseEntity getTopicsByProfessorId(@PathVariable Long professorId) {
        try {
            return new ResponseEntity<>(this.topicService.getAllTopicsByProfessorId(professorId), HttpStatus.OK);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{topicId}")
    public ResponseEntity getTopicById(@PathVariable Long topicId) {
        try {
            return new ResponseEntity<>(this.topicService.getTopicDTOById(topicId), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
