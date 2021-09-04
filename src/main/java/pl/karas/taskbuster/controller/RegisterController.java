package pl.karas.taskbuster.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.karas.taskbuster.model.entities.Authority;
import pl.karas.taskbuster.model.entities.RegisterRequest;
import pl.karas.taskbuster.model.entities.User;
import pl.karas.taskbuster.service.AuthorityService;
import pl.karas.taskbuster.service.UserService;

@RestController("/api")
public class RegisterController {

    UserService userService;
    AuthorityService authorityService;

    @Autowired
    public RegisterController(UserService userService, AuthorityService authorityService) {
        this.userService = userService;
        this.authorityService = authorityService;
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody RegisterRequest registerRequest){

        Authority authority = registerRequest.getAuthority();
        User user = registerRequest.getUser();

        if(userService.findUserByUsername(user.getUsername()).isEmpty()){
            if(!authority.getAuthority().isEmpty() && !authority.getUsername().isEmpty()){
                authorityService.saveAuthority(authority);
            } else {
                return ResponseEntity.badRequest().body("Authority is required");
            }

            userService.saveUser(user);
            return ResponseEntity.ok("User registered!");
        }
        
    }


}
