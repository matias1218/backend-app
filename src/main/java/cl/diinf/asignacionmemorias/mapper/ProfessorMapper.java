package cl.diinf.asignacionmemorias.mapper;

import cl.diinf.asignacionmemorias.dto.ProfessorDTO;
import cl.diinf.asignacionmemorias.dto.ProfessorSimpleDTO;
import cl.diinf.asignacionmemorias.dto.ThesisSimpleDTO;
import cl.diinf.asignacionmemorias.models.Professor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class ProfessorMapper {
    public ProfessorDTO toProfessorDTO(Professor professor) {
        ProfessorDTO professorDTO = new ProfessorDTO();
        professorDTO.setId(professor.getId());
        professorDTO.setAcademic(professor.isAcademic());
        professorDTO.setEmail(professor.getEmail());
        professorDTO.setLastname1(professor.getLastname1());
        professorDTO.setLastname2(professor.getLastname2());
        professorDTO.setName(professor.getName());
        professorDTO.setTopics(professor.getTopics().stream().map(x -> new TopicMapper().toTopicDTO(x)).collect(Collectors.toList()));
        professorDTO.setGuides(professor.getTheses().stream().map(x -> new ThesisMapper().toThesisSimpleDTO(x)).collect(Collectors.toList()));
        professorDTO.setImageUrl(professor.getUrlImage());
        professorDTO.setCommissions(Stream.concat(professor.getCommision1().stream().map(x -> new ThesisMapper().toThesisSimpleDTO(x)).collect(Collectors.toList()).stream(),
                professor.getCommision2().stream().map(x -> new ThesisMapper().toThesisSimpleDTO(x)).collect(Collectors.toList()).stream()).
                collect(Collectors.toList()));
        return professorDTO;
    }

    public ProfessorSimpleDTO toProfessorSimpleDTO(Professor professor) {
        ProfessorSimpleDTO professorSimpleDTO = new ProfessorSimpleDTO();
        professorSimpleDTO.setAcademic(professor.isAcademic());
        professorSimpleDTO.setEmail(professor.getEmail());
        professorSimpleDTO.setId(professor.getId());
        professorSimpleDTO.setName(professor.getName() + " " + professor.getLastname1() + " " + professor.getLastname2());
        professorSimpleDTO.setImageUrl(professor.getUrlImage());
        // To set commission
        professorSimpleDTO.setCommissions(Stream.concat(professor.getCommision1().stream().map(x -> new ThesisMapper().toThesisSimpleDTO(x)).collect(Collectors.toList()).stream(),
                professor.getCommision2().stream().map(x -> new ThesisMapper().toThesisSimpleDTO(x)).collect(Collectors.toList()).stream()).
                collect(Collectors.toList()));
        return professorSimpleDTO;
    }
}
