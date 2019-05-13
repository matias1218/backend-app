package cl.diinf.asignacionmemorias.services;

import cl.diinf.asignacionmemorias.dao.ProgramDAO;
import cl.diinf.asignacionmemorias.models.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramService {

    private ProgramDAO programDAO;

    @Autowired
    public ProgramService(ProgramDAO programDAO) {
        this.programDAO = programDAO;
    }

    public List<Program> getAllPrograms() {
        return programDAO.findAll();
    }

    public Program getProgramByCode(int code){
        return programDAO.getProgramByCode(code);
    }
}

