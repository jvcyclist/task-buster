package pl.karas.taskbuster.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.karas.taskbuster.entities.Project;
import pl.karas.taskbuster.repositories.ProjectRepository;

import javax.websocket.server.PathParam;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProjectController {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectController(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    @GetMapping(value = "/projects", produces = "application/json")
    public ResponseEntity getAllProjects(){
        Iterable<Project> allProjects = this.projectRepository.findAll();

        return allProjects.iterator().hasNext() ?
                ResponseEntity.ok(allProjects)
                : ResponseEntity.badRequest().body("Not found projects");
    }

    @GetMapping(value = "/project/{id}", produces = "application/json")
    public ResponseEntity getProjectById(@PathVariable("id") String id){
        Optional<Project> projectById = this.projectRepository
                .findById(Long.valueOf(id));
        return projectById.isPresent() ?
                ResponseEntity.ok(projectById.get())
                : ResponseEntity.badRequest()
                                .body("Project with given number not found");
    }

}
