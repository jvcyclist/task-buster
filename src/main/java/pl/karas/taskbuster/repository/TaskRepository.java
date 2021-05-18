package pl.karas.taskbuster.repository;

import org.springframework.data.repository.CrudRepository;
import pl.karas.taskbuster.model.entities.Sprint;
import pl.karas.taskbuster.model.entities.Task;

import java.util.Optional;

public interface TaskRepository extends CrudRepository<Task, Integer> {
    public Iterable<Task> findAll();
    public Optional<Task> findById(Long id);
}
