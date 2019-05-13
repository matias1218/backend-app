package cl.diinf.asignacionmemorias.services;

import cl.diinf.asignacionmemorias.dao.ThesisDAO;
import cl.diinf.asignacionmemorias.models.Thesis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThesisService {

    private final ThesisDAO thesisDAO;

    @Autowired
    public ThesisService(ThesisDAO thesisDAO) {
        this.thesisDAO = thesisDAO;
    }

    public Thesis getThesisById(Long id) {
        return thesisDAO.findById(id).orElseThrow(() -> new RuntimeException("Thesis not found"));
    }
}
