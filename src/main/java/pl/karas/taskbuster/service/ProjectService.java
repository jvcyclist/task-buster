package pl.karas.taskbuster.service;

import pl.karas.taskbuster.model.entities.Project;
import pl.karas.taskbuster.model.entities.Task;

import java.util.Optional;

public interface ProjectService {

    public Iterable<Project> findAll();
    public Optional<Project> findById(Long id);
    public Project saveProject(Project project);
    public void deleteTaskById(Long valueOf);
    public Iterable<Project> findProjectByAdminUserName(String username);
}
