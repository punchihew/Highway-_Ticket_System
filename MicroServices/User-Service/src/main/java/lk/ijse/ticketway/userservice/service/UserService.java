package lk.ijse.ticketway.userservice.service;

import lk.ijse.ticketway.userservice.dto.LoginDTO;
import lk.ijse.ticketway.userservice.dto.UserDTO;

/**
 * @version: v0.0.1
 * @author: Navishka
 * @date: 7/4/2024
 */
public interface UserService {
    void registerUser(UserDTO userDTO);

    boolean loginUser(LoginDTO loginDTO);

    void updateUser(UserDTO userDTO);

    UserDTO getUser(String email);
}