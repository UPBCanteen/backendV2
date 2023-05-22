package com.upbCanteen.backend.controller;

import com.upbCanteen.backend.model.ERole;
import com.upbCanteen.backend.model.User;
import com.upbCanteen.backend.service.RoleService;
import com.upbCanteen.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping(path="/getUsers")
    public ResponseEntity<?> getAllUsers(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.getUsersForAdmin());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping(path = "/authentication/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {

        try {
            if (((user.getEmail() != null && !Objects.equals(user.getEmail(), ""))
                    && (user.getPassword() != null && !Objects.equals(user.getPassword(), ""))
                    )) {
                if (!userService.isPresent(user.getEmail())) {
                    user.setPassword(user.getPassword());
                    user.setRoles(roleService.getRoleName(ERole.ROLE_USER));
                    userService.save(user);
                    return ResponseEntity.status(HttpStatus.CREATED).body("You have been successfully registered!");
                } else {
                    return ResponseEntity.status(HttpStatus.CONFLICT).body("This e-mail already exists!");
                }
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing required credentials!");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping(path = "/deleteUser/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable String email){

        try {
            userService.getUserByEmail(email);
            return ResponseEntity.status(HttpStatus.OK).body("User deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
