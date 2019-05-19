package cl.diinf.asignacionmemorias.services;

import cl.diinf.asignacionmemorias.dao.StudentDAO;
import cl.diinf.asignacionmemorias.dto.NewStudentDTO;
import cl.diinf.asignacionmemorias.dto.StudentDTO;
import cl.diinf.asignacionmemorias.mapper.StudentMapper;
import cl.diinf.asignacionmemorias.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentDAO studentDAO;
    private final ThesisService thesisService;
    private final ProgramService programService;

    @Autowired
    public StudentService(StudentDAO studentDAO, ThesisService thesisService, ProgramService programService){
        this.studentDAO = studentDAO;
        this.thesisService = thesisService;
        this.programService = programService;
    }

    public Student getStudentFromNames(String name, String lastname){
        return this.studentDAO.findByNameAndLastname1(name, lastname);
    }

    public Student getStudentById(Long studentId){
        return studentDAO.findStudentById(studentId);
    }

    public boolean assignThesis(Long studentId, Long thesisId) {
        try{
            Student student = studentDAO.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
            //student.setThesis(thesisService.getThesisById(thesisId));
            if(student.getThesis() != null) {
                studentDAO.saveAndFlush(student);
                return true;
            }
            return false;
        }
        catch (Exception e){
            throw e;
        }
    }

    public StudentDTO createStudent(NewStudentDTO newStudentDTO) {
        try{
            Student student = new StudentMapper().fromNewStudentDTO(newStudentDTO);
            student.setProgram(this.programService.getProgramByCode(newStudentDTO.getCodeProgram()));
            if(student.getProgram() != null) {
                studentDAO.saveAndFlush(student);
                return new StudentMapper().toStudentDTO(getStudentById(student.getId()));
            }
            return null;
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    public List<StudentDTO> getAll() {
        try {
            return studentDAO.findAll().stream().map(x-> new StudentMapper().toStudentDTO(x)).collect(Collectors.toList());
        }
        catch (Exception e) {
            throw e;
        }
    }

}
