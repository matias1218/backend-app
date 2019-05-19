package cl.diinf.asignacionmemorias.services;

import cl.diinf.asignacionmemorias.dao.ProfessorDAO;
import cl.diinf.asignacionmemorias.dto.ProfessorDTO;
import cl.diinf.asignacionmemorias.mapper.ProfessorMapper;
import cl.diinf.asignacionmemorias.models.Professor;
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

    public Professor getProfessorbyId(Long id) {
        try {
            return this.professorDAO.findProfessorById(id);
        }
        catch (Exception e) {
            throw e;
        }

    }

    public List<ProfessorDTO> getAll() {
        try {
            return  professorDAO.findAll().stream().map(x-> new ProfessorMapper().toProfessorDTO(x)).collect(Collectors.toList());
        }
        catch (Exception e) {
            throw e;
        }
    }



}
