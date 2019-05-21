package cl.diinf.asignacionmemorias.mapper;

import cl.diinf.asignacionmemorias.dto.ProfessorDTO;
import cl.diinf.asignacionmemorias.dto.ProfessorSimpleDTO;
import cl.diinf.asignacionmemorias.models.Professor;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Collectors;

@Slf4j
public class ProfessorMapper {
    public ProfessorDTO toProfessorDTO(Professor professor) {
        ProfessorDTO professorDTO = new ProfessorDTO();
        professor.setId(professor.getId());
        professorDTO.setAcademic(professor.isAcademic());
        professorDTO.setEmail(professor.getEmail());
        professorDTO.setLastname1(professor.getLastname1());
        professorDTO.setLastname2(professor.getLastname2());
        professorDTO.setName(professor.getName());
        professorDTO.setTopics(professor.getTopics().stream().map(x -> new TopicMapper().toTopicDTO(x)).collect(Collectors.toList()));
        professorDTO.setGuides(professor.getTheses().stream().map(x -> new ThesisMapper().toThesisSimpleDTO(x)).collect(Collectors.toList()));
        /*TODO
        Add commission to professor
        * */
        return professorDTO;
    }

    public ProfessorSimpleDTO toProfessorSimpleDTO(Professor professor) {
        ProfessorSimpleDTO professorSimpleDTO = new ProfessorSimpleDTO();
        professorSimpleDTO.setAcademic(professor.isAcademic());
        professorSimpleDTO.setEmail(professor.getEmail());
        professorSimpleDTO.setId(professor.getId());
        professorSimpleDTO.setName(professor.getName() + " " + professor.getLastname1() + " " + professor.getLastname2());
        return professorSimpleDTO;
    }
}
