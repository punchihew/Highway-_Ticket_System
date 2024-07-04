package lk.ijse.ticketway.userservice.service.impl;

import lk.ijse.ticketway.userservice.dto.LoginDTO;
import lk.ijse.ticketway.userservice.dto.UserDTO;
import lk.ijse.ticketway.userservice.entity.User;
import lk.ijse.ticketway.userservice.repository.UserRepository;
import lk.ijse.ticketway.userservice.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

/**
 * @version: v0.0.1
 * @author: Navishka
 * @date: 7/4/2024
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;

    private final Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public void registerUser(UserDTO userDTO) {
        userRepository.save(mapper.map(userDTO, User.class));
        logger.info("User Saved Successfully");
    }

    @Override
    public boolean loginUser(LoginDTO loginDTO) {
        User byName = userRepository.findByName(loginDTO.getUsername());
        return byName != null && byName.getPassword().equals(loginDTO.getPassword());
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        userRepository.findById(userDTO.getId()).ifPresent(user -> {
            userRepository.save(mapper.map(userDTO, User.class));
        });
        logger.info("User Updated Successfully");
    }

    @Override
    public UserDTO getUser(String email) {
        User byName = userRepository.findByEmail(email);
        return mapper.map(byName, UserDTO.class);
    }
}

