package cl.diinf.asignacionmemorias.controllers;

import cl.diinf.asignacionmemorias.dto.NewStudentDTO;
import cl.diinf.asignacionmemorias.dto.StudentDTO;
import cl.diinf.asignacionmemorias.services.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
@Slf4j
@CrossOrigin
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity createStudent(@RequestBody NewStudentDTO newStudentDTO){
        try{
            StudentDTO studentDTO = this.studentService.createStudent(newStudentDTO);
            if(studentDTO != null)
                return new ResponseEntity<>(studentDTO, HttpStatus.CREATED);
            return  new ResponseEntity<>("Code program not exists or student already in database", HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity getStudents() {
        try {
            return new ResponseEntity<>(this.studentService.getAllStudents(), HttpStatus.OK);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{studentId}/assign/{professorId}")
    public ResponseEntity assignComission(@PathVariable Long studentId, @PathVariable Long professorId) {
        try {
            return new ResponseEntity<>(this.studentService.assignCommission(studentId, professorId), HttpStatus.OK);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    /*@RequestMapping(method = RequestMethod.POST, value = "/assign")
    public ResponseEntity assignThesis(@RequestParam("studentId") int studentId, @RequestParam("thesisId") int thesisId){
        try{
            return new ResponseEntity<>(studentService.assignThesis((long)studentId, (long)thesisId), HttpStatus.OK);
        }
        catch (Exception e){
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }*/
}
