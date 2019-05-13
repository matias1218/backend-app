package cl.diinf.asignacionmemorias.mapper;

import cl.diinf.asignacionmemorias.dto.NewThesisDTO;
import cl.diinf.asignacionmemorias.dto.ThesisDTO;
import cl.diinf.asignacionmemorias.models.Thesis;

public class ThesisMapper {
    public Thesis fromNewThesisDTO(NewThesisDTO newThesisDTO)
    {
        Thesis thesis = new Thesis();
        thesis.setTitle(newThesisDTO.getTitle());
        thesis.setDescription(newThesisDTO.getDescription());
        return thesis;
    }

    public ThesisDTO toThesisDTO(Thesis thesis) {
        ThesisDTO thesisDTO = new ThesisDTO();
        thesisDTO.setTitle(thesis.getTitle());
        thesisDTO.setDescription(thesis.getDescription());
        thesisDTO.setTopic(thesis.getTopic().getName());
        return thesisDTO;
    }
}
