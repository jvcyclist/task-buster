package pl.karas.taskbuster.repository;

import org.springframework.data.repository.CrudRepository;
import pl.karas.taskbuster.model.entities.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {

    Optional<User> findUserByUsername(String username);
    Iterable<User> findAll();

}
