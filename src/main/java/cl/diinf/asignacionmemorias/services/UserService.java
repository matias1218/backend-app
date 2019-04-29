package cl.diinf.asignacionmemorias.services;

import cl.diinf.asignacionmemorias.models.User;
import cl.diinf.asignacionmemorias.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")

public class UserService {
    @Autowired
    private UserRepository userRepository;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUsers(){
        return this.userRepository.findAll();
    }


    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
