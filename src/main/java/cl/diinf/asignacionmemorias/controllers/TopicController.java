package cl.diinf.asignacionmemorias.controllers;



import cl.diinf.asignacionmemorias.dao.TopicDAO;
import cl.diinf.asignacionmemorias.models.Professor;
import cl.diinf.asignacionmemorias.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/topics")

public class TopicController {
    @Autowired
    private TopicDAO topicDAO;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Topic> getTopics(){
        return this.topicDAO.findAll();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Topic createTopic(@RequestBody Topic topic) {
        return topicDAO.save(topic);
    }

    @CrossOrigin
    @RequestMapping(value = "/{topicId}/professors", method = RequestMethod.GET )
    @ResponseBody
    public Set<Professor> getProfessorsByTopic(@PathVariable  Long topicId){

        return this.topicDAO.getProfessorsByTopic(topicId);
    }

}
