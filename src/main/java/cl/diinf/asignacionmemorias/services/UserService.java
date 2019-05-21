package cl.diinf.asignacionmemorias.services;

import cl.diinf.asignacionmemorias.dao.UserDAO;
import cl.diinf.asignacionmemorias.dto.NewUserDTO;
import cl.diinf.asignacionmemorias.dto.UserDTO;
import cl.diinf.asignacionmemorias.mapper.UserMapper;
import cl.diinf.asignacionmemorias.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    private User getUserByEmail(String email) {
        return this.userDAO.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found by email"));
    }

    public UserDTO login(String email, String password) {
        return new UserMapper().UsertoUserDTO(userDAO.findByEmailAndPassword(email, password).orElseThrow(()-> new RuntimeException("User not found for login")));
    }

    public User register(NewUserDTO newUserDTO) {
        try {
            if(this.userDAO.existsByEmail(newUserDTO.getEmail()))
                throw new RuntimeException("Email has been used");
            User user = new UserMapper().fromNewUserDTO(newUserDTO);
            userDAO.saveAndFlush(user);
            return this.getUserByEmail(user.getEmail());
        }
        catch (Exception e) {
            throw e;
        }

    }

    public List<UserDTO> getAll() {
        return this.userDAO.findAll().stream().map(x -> new UserMapper().UsertoUserDTO(x)).collect(Collectors.toList());
    }
}