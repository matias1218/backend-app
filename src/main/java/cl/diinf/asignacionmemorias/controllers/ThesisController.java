package cl.diinf.asignacionmemorias.controllers;

import cl.diinf.asignacionmemorias.dto.ThesisDTO;
import cl.diinf.asignacionmemorias.services.ThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/theses")   // (asi se dice el plural de tesis en ingles xd)

public class ThesisController {

    private ThesisService thesisService;

    @Autowired
    public ThesisController(ThesisService thesisService) {
        this.thesisService = thesisService;
    }


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<ThesisDTO> getAllThesis(){
        return this.thesisService.getAllTheses();
    }

}
