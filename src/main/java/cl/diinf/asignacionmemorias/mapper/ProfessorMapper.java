package cl.diinf.asignacionmemorias.mapper;

import cl.diinf.asignacionmemorias.dto.ProfessorDTO;
import cl.diinf.asignacionmemorias.models.Professor;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Collectors;

@Slf4j
public class ProfessorMapper {
    public ProfessorDTO toProfessorDTO(Professor professor) {
        ProfessorDTO professorDTO = new ProfessorDTO();
        professorDTO.setAcademic(professor.isAcademic());
        professorDTO.setEmail(professor.getEmail());
        professorDTO.setLastname1(professor.getLastname1());
        professorDTO.setLastname2(professor.getLastname2());
        professorDTO.setName(professor.getName());
        professorDTO.setTopics(professor.getTopics().stream().map(x -> new TopicMapper().toTopicSimpleDTO(x)).collect(Collectors.toList()));
        return professorDTO;
    }
}
