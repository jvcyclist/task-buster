package pl.karas.taskbuster.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import pl.karas.taskbuster.entities.Sprint;

import java.util.Optional;

@Component
public interface SprintRepository extends CrudRepository<Sprint, Long> {
    
    public Iterable<Sprint> findAll();
    public Optional<Sprint> findAllById(Long id);
}
