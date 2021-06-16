package pl.karas.taskbuster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.karas.taskbuster.model.entities.User;
import pl.karas.taskbuster.service.UserService;
import pl.karas.taskbuster.service.UserServiceImpl;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {


    private UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user/{username}")
    public ResponseEntity getUserByName(@PathVariable("username") String username){
        Optional<User> userByUsername = userService.findUserByUsername(username);

        return userByUsername.isPresent() ?
                ResponseEntity.ok(userByUsername.get())
                :ResponseEntity.badRequest()
                .body("User with given username not found!");

    }

    @GetMapping(value = "/users")
    public ResponseEntity getAllUsers(){
        Iterable<User> allUsers = userService.findAllUsers();
        return allUsers.iterator().hasNext() ?
                ResponseEntity.ok(allUsers)
                :ResponseEntity.badRequest()
                .body("There is no Users");
    }

    
}
