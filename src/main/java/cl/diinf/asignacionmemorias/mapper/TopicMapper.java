package cl.diinf.asignacionmemorias.mapper;

import cl.diinf.asignacionmemorias.dto.TopicDTO;
import cl.diinf.asignacionmemorias.dto.TopicDataDTO;
import cl.diinf.asignacionmemorias.models.Topic;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Collectors;

@Slf4j
public class TopicMapper {
    public TopicDTO toTopicDTO(Topic topic) {
        TopicDTO topicDTO = new TopicDTO();
        topicDTO.setId(topic.getId());
        topicDTO.setName(topic.getName());
        return topicDTO;
    }

    public TopicDataDTO toTopicDataDTO(Topic topic) {
        TopicDataDTO topicDataDTO = new TopicDataDTO();
        topicDataDTO.setId(topic.getId());
        topicDataDTO.setName(topic.getName());
        topicDataDTO.setProfessors(topic.getProfessors().stream().map(x-> new ProfessorMapper().toProfessorSimpleDTO(x)).collect(Collectors.toList()));
        topicDataDTO.setTheses(topic.getTheses().stream().map(x-> new ThesisMapper().toThesisDTO(x)).collect(Collectors.toList()));
        return topicDataDTO;
    }
}