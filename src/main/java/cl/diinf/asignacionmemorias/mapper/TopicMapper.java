package cl.diinf.asignacionmemorias.mapper;

import cl.diinf.asignacionmemorias.dto.TopicDTO;
import cl.diinf.asignacionmemorias.models.Topic;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TopicMapper {
    public TopicDTO toTopicSimpleDTO(Topic topic) {
        TopicDTO topicSimpleDTO = new TopicDTO();
        topicSimpleDTO.setId(topic.getId());
        topicSimpleDTO.setName(topic.getName());
        return topicSimpleDTO;
    }
}
