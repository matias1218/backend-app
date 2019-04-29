package cl.diinf.asignacionmemorias.services;

import cl.diinf.asignacionmemorias.models.Topic;
import cl.diinf.asignacionmemorias.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/topics")

public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Topic> getTopics(){
        return this.topicRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Topic createTopic(@RequestBody Topic topic) {
        return topicRepository.save(topic);
    }
}
