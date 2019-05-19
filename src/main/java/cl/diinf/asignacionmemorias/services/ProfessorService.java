package cl.diinf.asignacionmemorias.services;

import cl.diinf.asignacionmemorias.dao.ProfessorDAO;
import cl.diinf.asignacionmemorias.dto.ProfessorDTO;
import cl.diinf.asignacionmemorias.mapper.ProfessorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorService {

    private final ProfessorDAO professorDAO;

    @Autowired
    public ProfessorService(ProfessorDAO professorDAO) {
        this.professorDAO = professorDAO;
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
}
