package cl.diinf.asignacionmemorias.mapper;

import cl.diinf.asignacionmemorias.dto.ThesisDTO;
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
}
