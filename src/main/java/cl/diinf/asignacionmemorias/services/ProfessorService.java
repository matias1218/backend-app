package cl.diinf.asignacionmemorias.services;

import cl.diinf.asignacionmemorias.dao.ProfessorDAO;
import cl.diinf.asignacionmemorias.dao.TopicDAO;
import cl.diinf.asignacionmemorias.dto.ProfessorDTO;
import cl.diinf.asignacionmemorias.mapper.ProfessorMapper;
import cl.diinf.asignacionmemorias.models.Professor;
import cl.diinf.asignacionmemorias.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorService {

    private ProfessorDAO professorDAO;
    private TopicDAO topicDAO;

    @Autowired
    public ProfessorService(ProfessorDAO professorDAO, TopicDAO topicDAO) {
        this.professorDAO = professorDAO;
        this.topicDAO = topicDAO;
    }

    public Professor getProfessorById(Long professorId) {
        return professorDAO.findById(professorId).orElseThrow(()-> new RuntimeException("Professor not found"));
    }

    public ProfessorDTO getProfessorDTOById(Long professorId) {
        return new ProfessorMapper().toProfessorDTO(this.getProfessorById(professorId));
    }

    public List<ProfessorDTO> getAllProfessors() {
        try {
            return  professorDAO.findAll().stream().map(x-> new ProfessorMapper().toProfessorDTO(x)).collect(Collectors.toList());
        }
        catch (Exception e) {
            throw e;
        }
    }

    public List<ProfessorDTO> getProffessorsByTopicId(Long topicId) {
        try {
            return professorDAO.findProfessorsByTopicId(topicId).stream().map(x-> new ProfessorMapper().toProfessorDTO(x)).collect(Collectors.toList());
        }
        catch (Exception e) {
            throw e;
        }
    }

    public ProfessorDTO putTopic(Long professorId, Long topicId) {
        try {
            Topic topic = this.topicDAO.findById(topicId).orElseThrow(() -> new RuntimeException("Topic not found"));
            Professor professor = this.getProfessorById(professorId);
            if(topic != null && professor != null && !professor.getTopics().contains(topic)) {
                professor.addTopic(topic);
                professorDAO.saveAndFlush(professor);
            }
            return new ProfessorMapper().toProfessorDTO(professor);
        }
        catch (Exception e) {
            throw e;
        }
    }
}
