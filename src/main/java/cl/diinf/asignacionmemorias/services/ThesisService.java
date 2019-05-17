package cl.diinf.asignacionmemorias.services;

import cl.diinf.asignacionmemorias.dao.ThesisDAO;
import cl.diinf.asignacionmemorias.dto.ThesisDTO;
import cl.diinf.asignacionmemorias.mapper.ThesisMapper;
import cl.diinf.asignacionmemorias.models.Thesis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ThesisService {

    private final ThesisDAO thesisDAO;

    @Autowired
    public ThesisService(ThesisDAO thesisDAO) {
        this.thesisDAO = thesisDAO;
    }

    public Thesis getThesisById(Long id) {
        return thesisDAO.findById(id).orElseThrow(() -> new RuntimeException("Thesis not found"));
    }

    public List<ThesisDTO> getByProfessorId(Long professorId) {
        try {
            return this.thesisDAO.findThesesByProfessorId(professorId).stream().map(x -> new ThesisMapper().toThesisDTO(x)).collect(Collectors.toList());
        }
        catch (Exception e) {
            throw e;
        }
    }
}
