package cl.diinf.asignacionmemorias.services;

import cl.diinf.asignacionmemorias.dao.ThesisDAO;
import cl.diinf.asignacionmemorias.dao.TopicDAO;
import cl.diinf.asignacionmemorias.dto.ThesisDTO;
import cl.diinf.asignacionmemorias.dto.TopicDTO;
import cl.diinf.asignacionmemorias.mapper.ThesisMapper;
import cl.diinf.asignacionmemorias.mapper.TopicMapper;
import cl.diinf.asignacionmemorias.models.Thesis;
import cl.diinf.asignacionmemorias.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TopicService {

    private final TopicDAO topicDAO;


    @Autowired
    public TopicService(TopicDAO topicDAO) {
        this.topicDAO = topicDAO;

    }

    public Topic getTopicById(Long id) {
        return topicDAO.findById(id).orElseThrow(() -> new RuntimeException("Thesis not found"));
    }

    public List<TopicDTO> getAllTopics()
    {
        try {
            return topicDAO.findAll().stream().map(x -> new TopicMapper().toTopicSimpleDTO(x)).collect(Collectors.toList());
        }
        catch (Exception e)
        {
            throw e;
        }
    }



}
