package cl.diinf.asignacionmemorias.mapper;

import cl.diinf.asignacionmemorias.dto.NewStudentDTO;
import cl.diinf.asignacionmemorias.dto.StudentDTO;
import cl.diinf.asignacionmemorias.models.Student;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentMapper {
    public Student fromNewStudentDTO(NewStudentDTO newStudentDTO){
        Student student = new Student();
        student.setName(newStudentDTO.getName());
        student.setLastname1(newStudentDTO.getLastname1());
        student.setLastname2(newStudentDTO.getLastname2());
        student.setEmail(newStudentDTO.getEmail());
        student.setIncome(newStudentDTO.getIncome());
        return student;
    }

    public StudentDTO toStudentDTO(Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(student.getName());
        studentDTO.setLastname1(student.getLastname1());
        studentDTO.setLastname2(student.getLastname2());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setIncome(student.getIncome());
        studentDTO.setProgram(new ProgramMapper().toProgramDTO(student.getProgram()));
        return studentDTO;
    }
}
