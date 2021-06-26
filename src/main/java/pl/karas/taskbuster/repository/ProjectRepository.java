package pl.karas.taskbuster.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import pl.karas.taskbuster.model.entities.Project;

import java.util.Optional;

@Component
public interface ProjectRepository extends CrudRepository<Project, Long> {

    public Iterable<Project> findAll();
    public Optional<Project> findById(Long id);
}
