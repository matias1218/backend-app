package cl.diinf.asignacionmemorias.services;

import cl.diinf.asignacionmemorias.dao.TopicDAO;
import cl.diinf.asignacionmemorias.dto.TopicDTO;
import cl.diinf.asignacionmemorias.mapper.TopicMapper;
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

    /*public List<TopicDTO> getByProfessorId(Long professorId) {
        try {
            return this.topicDAO.findTopicsByProfessorId(professorId).stream().map(x-> new TopicMapper().toTopicSimpleDTO(x)).collect(Collectors.toList());
        }
        catch (Exception e)
        {
            throw e;
        }
    }*/
}
