package cl.diinf.asignacionmemorias.services;

import cl.diinf.asignacionmemorias.dao.ThesisDAO;
import cl.diinf.asignacionmemorias.dto.ThesisDTO;
import cl.diinf.asignacionmemorias.mapper.ThesisMapper;
import cl.diinf.asignacionmemorias.models.Thesis;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ThesisService {

    private final ThesisDAO thesisDAO;
    private final ProfessorService professorService;

    @Autowired
    public ThesisService(ThesisDAO thesisDAO, ProfessorService professorService) {
        this.thesisDAO = thesisDAO;
        this.professorService = professorService;
    }

    private Thesis getThesisById(Long id) {
        return thesisDAO.findById(id).orElseThrow(() -> new RuntimeException("Thesis not found"));
    }

    /*public List<ThesisDTO> getByProfessorId(Long professorId) {
        try {
            return this.thesisDAO.findThesesByProfessorId(professorId).stream().map(x -> new ThesisMapper().toThesisDTO(x)).collect(Collectors.toList());
        }
        catch (Exception e) {
            throw e;
        }
    }*/

    public boolean assignComission(Long professorId, Long thesisId) {
        try {
            log.error("adsa");
            Thesis thesis = this.thesisDAO.findThesisById(thesisId);
            log.error("adsadsadas");
            //Professor professor = this.professorService.getProfessorbyId(professorId);
            //log.error(thesis.getTitle());
            //log.error(professor.getEmail());
            log.info("KIE");

/*            if(thesis.getCommissionFirst() != null && professor != null) {
                thesis.setCommissionFirst(professor);
                thesisDAO.save(thesis);
                return true;
            }
            else if(thesis.getCommissionSecond() != null && professor != null) {
                thesis.setCommissionSecond(professor);
                thesisDAO.save(thesis);
                return true;
            }*/
            return false;
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    public List<ThesisDTO> getAll() {
        try {
            return thesisDAO.findAll().stream().map(x-> new ThesisMapper().toThesisDTO(x)).collect(Collectors.toList());
        }
        catch (Exception e) {
            throw e;
        }
    }
}
