package pl.karas.taskbuster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.karas.taskbuster.model.entities.User;
import pl.karas.taskbuster.repository.UserRepository;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return this.userRepository.findUserByUsername(username);
    }


    @Override
    public Iterable<User> findAllUsers() {
        return this.userRepository.findAll();
    }






}
