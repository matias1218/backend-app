package cl.diinf.asignacionmemorias.controllers;

import cl.diinf.asignacionmemorias.dao.UserDAO;
import cl.diinf.asignacionmemorias.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")

public class UserController {
    @Autowired
    private UserDAO userDAO;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUsers(){
        return this.userDAO.findAll();
    }


    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public User createUser(@RequestBody User user) {
        return userDAO.save(user);
    }
}
