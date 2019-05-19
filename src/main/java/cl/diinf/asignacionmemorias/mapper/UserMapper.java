package cl.diinf.asignacionmemorias.mapper;

import cl.diinf.asignacionmemorias.dto.NewUserDTO;
import cl.diinf.asignacionmemorias.dto.UserDTO;
import cl.diinf.asignacionmemorias.models.User;

public class UserMapper {
    public UserDTO UsertoUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setLastname(user.getLastname());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    public User fromNewUserDTO(NewUserDTO newUserDTO) {
        User user = new User();
        user.setName(newUserDTO.getName());
        user.setLastname(newUserDTO.getLastname());
        user.setEmail(newUserDTO.getEmail());
        user.setPassword(newUserDTO.getPassword());
        return user;
    }
}
