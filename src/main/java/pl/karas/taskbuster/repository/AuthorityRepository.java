package pl.karas.taskbuster.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import pl.karas.taskbuster.model.entities.Authority;

import java.util.Set;

@Component
public interface AuthorityRepository extends CrudRepository<Authority, Integer> {

    Set<Authority> findAllByUsernameAndAuthority(String username, String Authority);


}
