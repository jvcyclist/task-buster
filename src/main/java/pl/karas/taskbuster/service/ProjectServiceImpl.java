package pl.karas.taskbuster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.karas.taskbuster.model.entities.Project;
import pl.karas.taskbuster.model.entities.Task;
import pl.karas.taskbuster.repository.ProjectRepository;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService{

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    @Override
    public Iterable<Project> findAll() {
        return this.projectRepository.findAll();
    }

    @Override
    public Optional<Project> findById(Long id) {
        return this.projectRepository.findById(id);
    }

    @Override
    public Project saveProject(Project project) {
        return this.projectRepository.save(project);
    }

    @Override
    public void deleteTaskById(Long id) {
         this.projectRepository.deleteById(id);
    }
}
