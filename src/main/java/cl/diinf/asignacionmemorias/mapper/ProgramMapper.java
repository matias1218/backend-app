package cl.diinf.asignacionmemorias.mapper;

import cl.diinf.asignacionmemorias.dto.ProgramDTO;
import cl.diinf.asignacionmemorias.models.Program;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProgramMapper {
    public ProgramDTO toProgramDTO(Program program){
        ProgramDTO programDTO = new ProgramDTO();
        programDTO.setCode(program.getCode());
        programDTO.setName(program.getName());
        return programDTO;
    }
}
