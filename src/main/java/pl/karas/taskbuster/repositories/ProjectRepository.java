package pl.karas.taskbuster.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import pl.karas.taskbuster.entities.Project;

import java.util.Optional;

@Component
public interface ProjectRepository extends CrudRepository<Project, Long> {

    public Iterable<Project> findAll();
    public Optional<Project> findById(Long id);

}
