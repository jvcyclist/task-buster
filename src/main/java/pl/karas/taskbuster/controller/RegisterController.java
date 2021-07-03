package pl.karas.taskbuster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.karas.taskbuster.model.entities.Authority;
import pl.karas.taskbuster.model.entities.User;
import pl.karas.taskbuster.repository.UserRepository;
import pl.karas.taskbuster.service.AuthorityService;
import pl.karas.taskbuster.service.UserService;

import java.util.Set;
@CrossOrigin()
@RestController
@RequestMapping("/api")
public class RegisterController {


    UserService userService;
    AuthorityService authorityService;
  //  PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterController(UserService userService,
                              AuthorityService authorityService
                              //PasswordEncoder passwordEncoder
                              ) {
        this.userService = userService;
        this.authorityService = authorityService;
      //  this.passwordEncoder = passwordEncoder;
    }

    @PostMapping(value = "/register")
    public ResponseEntity registerAccount(@RequestBody User user){
            if(userService.findUserByUsername(user.getUsername()).isEmpty()){
                User userToAdd = new User();
                userToAdd.setUsername(user.getUsername());
            //    userToAdd.setPassword(passwordEncoder.encode(user.getPassword()));
                userToAdd.setEnabled(true);

                Authority authorityToAdd = new Authority();
                if(
                this.authorityService
                        .findAuthoritiesByUserNameAndRole(
                                user.getUsername(),
                                "ROLE_USER")
                        .isEmpty()
                )
                {
                    authorityToAdd.setUsername(user.getUsername());
                    authorityToAdd.setAuthority("ROLE_USER");
                }
                userToAdd.setAuthorities(Set.of(authorityToAdd));
                this.userService.saveUser(userToAdd);

                return ResponseEntity.ok().build();
            }
            else{
                return ResponseEntity.badRequest().build();
            }
    }

}
