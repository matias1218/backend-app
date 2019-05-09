package cl.diinf.asignacionmemorias.controllers;

import cl.diinf.asignacionmemorias.dao.CommissionDAO;
import cl.diinf.asignacionmemorias.dao.ProfessorDAO;
import cl.diinf.asignacionmemorias.models.Commission;
import cl.diinf.asignacionmemorias.models.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/commissions")

public class CommissionController {
    @Autowired
    private CommissionDAO commissionDAO;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Commission> getCommissions(){
        return this.commissionDAO.findAll();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Commission createCommission(@RequestBody Commission commission) {
        return commissionDAO.save(commission);
    }
}
