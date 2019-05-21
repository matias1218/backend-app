package cl.diinf.asignacionmemorias.services;

import cl.diinf.asignacionmemorias.dao.ProfessorDAO;
import cl.diinf.asignacionmemorias.dao.ProgramDAO;
import cl.diinf.asignacionmemorias.dao.StudentDAO;
import cl.diinf.asignacionmemorias.dto.NewStudentDTO;
import cl.diinf.asignacionmemorias.dto.StudentDTO;
import cl.diinf.asignacionmemorias.mapper.StudentMapper;
import cl.diinf.asignacionmemorias.models.Professor;
import cl.diinf.asignacionmemorias.models.Program;
import cl.diinf.asignacionmemorias.models.Student;
import cl.diinf.asignacionmemorias.models.Thesis;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class StudentService {
    private StudentDAO studentDAO;
    private ProgramDAO programDAO;
    private ProfessorDAO professorDAO;

    @Autowired
    public StudentService(StudentDAO studentDAO, ProgramDAO programDAO, ProfessorDAO professorDAO){
        this.studentDAO = studentDAO;
        this.programDAO = programDAO;
        this.professorDAO = professorDAO;
    }

    public Student getStudentFromNames(String name, String lastname){
        return this.studentDAO.findByNameAndLastname1(name, lastname);
    }

    public Student getStudentById(Long studentId){
        return studentDAO.findById(studentId).orElseThrow(()-> new RuntimeException("Student not found"));
    }

    /*public boolean assignThesis(Long studentId, Long thesisId){
        try{
            Student student = studentDAO.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
            student.setThesis(thesisDAO.findById(thesisId).orElseThrow(() -> new RuntimeException("Thesis not found")));
            if(student.getThesis() != null) {
                studentDAO.saveAndFlush(student);
                return true;
            }
            return false;
        }
        catch (Exception e){
            throw e;
        }
    }*/

    public StudentDTO createStudent(NewStudentDTO newStudentDTO){
        try{
            Student student = new StudentMapper().fromNewStudentDTO(newStudentDTO);
            Program program = this.programDAO.findByCode(newStudentDTO.getCodeProgram()).orElseThrow(() -> new RuntimeException("Program not found"));
            student.addProgram(program);
            studentDAO.saveAndFlush(student);
            return new StudentMapper().toStudentDTO(getStudentById(student.getId()));
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    public List<StudentDTO> getAllStudents() {
        try {
            return studentDAO.findAll().stream().map(x-> new StudentMapper().toStudentDTO(x)).collect(Collectors.toList());
        }
        catch (Exception e) {
            throw e;
        }
    }

    public boolean assignCommission(Long studentId, Long professorId) {
        try {
            Student student = this.getStudentById(studentId);
            Professor professor = this.professorDAO.findById(professorId).orElseThrow(()-> new RuntimeException("Professor not found"));
            Thesis thesis = student.getThesis();
            if(thesis.getGuide().getId().equals(professorId)) {
                return false;
            }
            else if(thesis.getCommissionFirst() == null) {
                if(thesis.getCommissionSecond() != null && thesis.getCommissionSecond().getId().equals(professorId))
                    return false;
                student.getThesis().setCommissionFirst(professor);
            }
            else if(thesis.getCommissionSecond() == null) {
                if(thesis.getCommissionFirst() != null && thesis.getCommissionFirst().getId().equals(professorId))
                    return false;
                student.getThesis().setCommissionSecond(professor);
            }
            else
                return false;
            this.studentDAO.saveAndFlush(student);
            return true;
        }
        catch (Exception e) {
            throw e;
        }
    }
}
