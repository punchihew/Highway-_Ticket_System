package lk.ijse.ticketway.userservice.controller;

import lk.ijse.ticketway.userservice.dto.LoginDTO;
import lk.ijse.ticketway.userservice.dto.UserDTO;
import lk.ijse.ticketway.userservice.service.UserService;
import lk.ijse.ticketway.userservice.util.ResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @version: v0.0.1
 * @author: Navishka
 * @date: 7/4/2024
 */
@RestController
@RequestMapping("/actions")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseDTO login(@RequestBody LoginDTO loginDTO) {
        try {
            boolean b = userService.loginUser(loginDTO);
            return new ResponseDTO(b ? "Login Success" : "Login Failed", 200);
        } catch (Exception e) {
            return new ResponseDTO(e.getMessage(), 500);
        }
    }

    @PostMapping("/register")
    public ResponseDTO register(@RequestBody UserDTO userDTO) {
        try {
            userService.registerUser(userDTO);
            return new ResponseDTO("User Saved Successfully", 200);
        } catch (Exception e) {
            return new ResponseDTO(e.getMessage(), 500);
        }
    }

    @PutMapping("/update")
    public ResponseDTO update(@RequestBody UserDTO userDTO) {
        try{
            userService.updateUser(userDTO);
            return new ResponseDTO("User Updated Successfully", 200);
        } catch (Exception e) {
            return new ResponseDTO(e.getMessage(), 500);
        }
    }

    @GetMapping("/get-user/{email}")
    public ResponseDTO getUser(@PathVariable String email){
        System.out.println(email);
        try{
            HashMap<String, Object> objectObjectHashMap = new HashMap<>();
            objectObjectHashMap.put("user", userService.getUser(email));
            return new ResponseDTO(200,"User Found Success Full !" ,objectObjectHashMap);
        } catch (Exception e) {
            return new ResponseDTO(e.getMessage(), 500);
        }
    }
}
