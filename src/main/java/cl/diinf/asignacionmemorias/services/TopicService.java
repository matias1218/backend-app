package cl.diinf.asignacionmemorias.services;

import cl.diinf.asignacionmemorias.dao.TopicDAO;
import cl.diinf.asignacionmemorias.dto.TopicDTO;
import cl.diinf.asignacionmemorias.dto.TopicDataDTO;
import cl.diinf.asignacionmemorias.mapper.TopicMapper;
import cl.diinf.asignacionmemorias.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TopicService {

    private final TopicDAO topicDAO;

    @Autowired
    public TopicService(TopicDAO topicDAO) {
        this.topicDAO = topicDAO;
    }

    public Topic getTopicById(Long topicId) {
        return topicDAO.findById(topicId).orElseThrow(()-> new RuntimeException("Topic not found"));
    }

    public TopicDataDTO getTopicDTOById(Long topicId) {
        return new TopicMapper().toTopicDataDTO(this.getTopicById(topicId));
    }

    public List<TopicDTO> getAllTopicsByProfessorId(Long topicId) {
        return this.topicDAO.findTopicsByProfessorId(topicId).stream().map(x-> new TopicMapper().toTopicDTO(x)).collect(Collectors.toList());
    }

    public List<TopicDataDTO> getAllTopics() {
        return this.topicDAO.findAll().stream().map(x-> new TopicMapper().toTopicDataDTO(x)).collect(Collectors.toList());
    }
}
