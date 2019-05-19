package cl.diinf.asignacionmemorias.mapper;

import cl.diinf.asignacionmemorias.dto.ThesisDTO;
import cl.diinf.asignacionmemorias.models.Thesis;

public class ThesisMapper {
    public ThesisDTO toThesisDTO(Thesis thesis) {
        ThesisDTO thesisDTO = new ThesisDTO();
        thesisDTO.setTitle(thesis.getTitle());
        thesisDTO.setDescription(thesis.getDescription());
        //thesisDTO.setTopic(thesis.getTopic().getName());
        return thesisDTO;
    }
}
