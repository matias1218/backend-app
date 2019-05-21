package cl.diinf.asignacionmemorias.mapper;

import cl.diinf.asignacionmemorias.dto.NewThesisDTO;
import cl.diinf.asignacionmemorias.dto.ThesisDTO;
import cl.diinf.asignacionmemorias.dto.ThesisSimpleDTO;
import cl.diinf.asignacionmemorias.models.Thesis;

public class ThesisMapper {
    public ThesisDTO toThesisDTO(Thesis thesis) {
        ThesisDTO thesisDTO = new ThesisDTO();
        thesisDTO.setId(thesis.getId());
        thesisDTO.setTitle(thesis.getTitle());
        thesisDTO.setDescription(thesis.getDescription());
        thesisDTO.setTopic(thesis.getTopic().getName());
        thesisDTO.setTeacherGuide(new ProfessorMapper().toProfessorSimpleDTO(thesis.getGuide()));
        if(thesis.getCommissionFirst() != null)
            thesisDTO.setTeacherCommission1(new ProfessorMapper().toProfessorSimpleDTO(thesis.getCommissionFirst()));
        if(thesis.getCommissionSecond() != null)
            thesisDTO.setTeacherCommission2(new ProfessorMapper().toProfessorSimpleDTO(thesis.getCommissionSecond()));
        thesisDTO.setStudent(new StudentMapper().toStudentSimpleDTO(thesis.getStudent()));
        return thesisDTO;
    }

    public ThesisSimpleDTO toThesisSimpleDTO(Thesis thesis) {
        ThesisSimpleDTO thesisSimpleDTO = new ThesisSimpleDTO();
        thesisSimpleDTO.setDescription(thesis.getDescription());
        thesisSimpleDTO.setTitle(thesis.getTitle());
        thesisSimpleDTO.setId(thesis.getId());
        thesisSimpleDTO.setTopic(thesis.getTopic().getName());
        thesisSimpleDTO.setStudent(new StudentMapper().toStudentSimpleDTO(thesis.getStudent()));
        return thesisSimpleDTO;
    }

    public Thesis fromNewThesisDTO(NewThesisDTO newThesisDTO) {
        Thesis thesis = new Thesis();
        thesis.setTitle(newThesisDTO.getTitle());
        thesis.setDescription(newThesisDTO.getDescription());
        return thesis;
    }
}
