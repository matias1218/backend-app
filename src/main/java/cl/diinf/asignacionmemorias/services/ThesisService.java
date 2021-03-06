package cl.diinf.asignacionmemorias.services;

import cl.diinf.asignacionmemorias.dao.ThesisDAO;
import cl.diinf.asignacionmemorias.dto.NewThesisDTO;
import cl.diinf.asignacionmemorias.dto.ThesisDTO;
import cl.diinf.asignacionmemorias.mapper.ThesisMapper;
import cl.diinf.asignacionmemorias.models.Thesis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ThesisService {

    private ThesisDAO thesisDAO;
    private StudentService studentService;
    private ProfessorService professorService;
    private TopicService topicService;

    @Autowired
    public ThesisService(ThesisDAO thesisDAO, StudentService studentService, ProfessorService professorService, TopicService topicService) {
        this.thesisDAO = thesisDAO;
        this.studentService = studentService;
        this.professorService = professorService;
        this.topicService = topicService;
    }

    public Thesis getThesisById(Long id) {
        return thesisDAO.findById(id).orElseThrow(() -> new RuntimeException("Thesis not found"));
    }

    public List<ThesisDTO> getAllTheses()
    {
        try {
            return thesisDAO.findAll().stream().map(x -> new ThesisMapper().toThesisDTO(x)).collect(Collectors.toList());
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    public List<ThesisDTO> getThesesByProfessorId(Long professorId) {
        try {
            return thesisDAO.findThesesByProfessorId(professorId).stream().map(x-> new ThesisMapper().toThesisDTO(x)).collect(Collectors.toList());
        }
        catch (Exception e) {
            throw e;
        }
    }

    public List<ThesisDTO> getThesesCommissionId(Long professorId) {
        try {
            List<ThesisDTO> c1 = thesisDAO.findThesesByCommission1(professorId).stream().map(x-> new ThesisMapper().toThesisDTO(x)).collect(Collectors.toList());
            List<ThesisDTO> c2 = thesisDAO.findThesesByCommission2(professorId).stream().map(x-> new ThesisMapper().toThesisDTO(x)).collect(Collectors.toList());
            return Stream.concat(c1.stream(), c2.stream()).collect(Collectors.toList());
        }
        catch (Exception e) {
            throw e;
        }
    }

    public List<ThesisDTO> getThesesByTopicId(Long topicId) {
        try {
            return thesisDAO.findAllByTopicId(topicId).stream().map(x-> new ThesisMapper().toThesisDTO(x)).collect(Collectors.toList());
        }
        catch (Exception e) {
            throw e;
        }
    }

    public List<ThesisDTO> getThesesMissingCommission() {
        try {
            return thesisDAO.findAllByCommissionFirstIsNullOrCommissionSecondIsNull().stream().map(x-> new ThesisMapper().toThesisDTO(x)).collect(Collectors.toList());
        }
        catch (Exception e) {
            throw e;
        }
    }

    public List<ThesisDTO> getThesesFullCommission() {
        try {
            return thesisDAO.findAllByCommissionFirstIsNotNullOrCommissionSecondIsNotNull().stream().map(x-> new ThesisMapper().toThesisDTO(x)).collect(Collectors.toList());
        }
        catch (Exception e) {
            throw e;
        }
    }

    public ThesisDTO createThesis(NewThesisDTO newThesisDTO) {
        try {
            Thesis thesis = new ThesisMapper().fromNewThesisDTO(newThesisDTO);
            thesis.setStudent(this.studentService.getStudentById(newThesisDTO.getStudentId()));
            thesis.setGuide(this.professorService.getProfessorById(newThesisDTO.getGuideId()));
            thesis.setTopic(this.topicService.getTopicById(newThesisDTO.getTopicId()));
            if(thesis.getGuide() != null || thesis.getStudent() != null || thesis.getTopic() != null) {
                thesisDAO.saveAndFlush(thesis);
                return new ThesisMapper().toThesisDTO(getThesisById(thesis.getId()));
            }
            return null;
        }
        catch (Exception e) {
            throw e;
        }
    }

    /*public ThesisDTO createThesis(NewThesisDTO newThesisDTO) {
        Thesis thesis = new ThesisMapper().fromNewThesisDTO(newThesisDTO);
        thesis.setStudent(studentService.getStudentById(newThesisDTO.getStudentId()));
        //thesis.setGuide(teacherService.getTeacherById(newThesisDTO.getTeacherId()));
        //thesis.setTopic(topicService.getTopicById(newThesisDTO.getTopicId()));
        return new ThesisMapper().toThesisDTO(thesis);
    }*/

}
