package pl.karas.taskbuster.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.karas.taskbuster.model.entities.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findUserByUsername(String username);
    Iterable<User> findAllUsers();
    User saveUser(User user);
}
