package pl.karas.taskbuster.service;

import pl.karas.taskbuster.model.entities.Project;

import java.util.Optional;

public interface ProjectService {

    public Iterable<Project> findAll();
    public Optional<Project> findById(Long id);

}
