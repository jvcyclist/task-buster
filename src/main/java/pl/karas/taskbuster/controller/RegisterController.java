package pl.karas.taskbuster.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class RegisterController {


    @PostMapping(value = "/register")
    public void registerAccount(){
            /*
            Get values to register Account
            and then redirect to login
            If user already exist return 409
             */
    }


}
