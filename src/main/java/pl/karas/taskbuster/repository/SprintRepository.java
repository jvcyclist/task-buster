package pl.karas.taskbuster.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import pl.karas.taskbuster.model.entities.Sprint;

import java.util.Optional;

@Component
public interface SprintRepository extends CrudRepository<Sprint, Long> {
    
    public Iterable<Sprint> findAll();
    public Optional<Sprint> findById(Long id);
}
