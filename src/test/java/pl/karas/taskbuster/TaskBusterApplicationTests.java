package pl.karas.taskbuster;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.karas.taskbuster.model.entities.Authority;
import pl.karas.taskbuster.model.entities.User;
import pl.karas.taskbuster.service.AuthorityService;
import pl.karas.taskbuster.service.UserService;

import java.util.Set;

@SpringBootTest
class TaskBusterApplicationTests {

    private UserService userService;
    private AuthorityService authorityService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public TaskBusterApplicationTests(UserService userService, AuthorityService authorityService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.authorityService = authorityService;
        this.passwordEncoder = passwordEncoder;
    }

    @Test
    void contextLoads() {
    }









}
