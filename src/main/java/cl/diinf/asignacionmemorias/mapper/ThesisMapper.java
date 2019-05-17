package cl.diinf.asignacionmemorias.mapper;

import cl.diinf.asignacionmemorias.dto.ThesisDTO;
import cl.diinf.asignacionmemorias.models.Thesis;

public class ThesisMapper {
    public ThesisDTO toThesisDTO(Thesis thesis) {
        ThesisDTO thesisDTO = new ThesisDTO();
        thesisDTO.setTitle(thesis.getTitle());
        thesisDTO.setTopic(thesis.getTopic().getName());
        thesisDTO.setAuthor(thesis.getStudent().getName() +" "+ thesis.getStudent().getLastname1() +" "+ thesis.getStudent().getLastname2());
        return thesisDTO;
    }
}
