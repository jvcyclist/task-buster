package pl.karas.taskbuster.controller;

import antlr.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.karas.taskbuster.model.entities.Project;
import pl.karas.taskbuster.model.entities.Task;
import pl.karas.taskbuster.repository.ProjectRepository;
import pl.karas.taskbuster.service.ProjectService;

import java.util.Optional;
@CrossOrigin()
@RestController
@RequestMapping("/api")
public class ProjectController {

    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @GetMapping(value = "/projects", produces = "application/json")
    public ResponseEntity getAllProjects(@ModelAttribute(value="admin_username") String adminUserName){

        if(!adminUserName.isEmpty()){
            Iterable<Project> allProjectsByUsername = this.projectService.findProjectByAdminUserName(adminUserName);
            return allProjectsByUsername.iterator().hasNext() ?
                    ResponseEntity.ok(allProjectsByUsername)
                    : ResponseEntity.badRequest().body("Not found projects for given username");
        }
        else{
            Iterable<Project> allProjects = this.projectService.findAll();

            return allProjects.iterator().hasNext() ?
                    ResponseEntity.ok(allProjects)
                    : ResponseEntity.badRequest().body("Not found projects");
        }
    }

    @GetMapping(value = "/projects/{id}", produces = "application/json")
    public ResponseEntity getProjectById(@PathVariable("id") String id){
        Optional<Project> projectById = this.projectService
                .findById(Long.valueOf(id));

        return projectById.isPresent() ?
                ResponseEntity.ok(projectById.get())
                : ResponseEntity.badRequest()
                                .body("Project with given id not found");
    }

    @PostMapping(value = "/projects", produces = "application/json")
    public ResponseEntity<Project> addProject(@RequestBody Project project){
        return ResponseEntity.ok(this.projectService.saveProject(project));
    }

    @PutMapping("/projects/{id}")
    public ResponseEntity updateProject(@PathVariable("id") String id, @RequestBody Project project){
        Optional<Project> taskById = projectService.findById(Long.valueOf(id));
        if(taskById.isPresent()){
            this.projectService.saveProject(project);
            return ResponseEntity.accepted().build();
        }
        else return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity deleteProject(@PathVariable("id") String id){

        Optional<Project> taskById = projectService.findById(Long.valueOf(id));
        if(taskById.isPresent()){
            this.projectService.deleteTaskById(Long.valueOf(id));
            return ResponseEntity.accepted().build();
        }
        else return ResponseEntity.notFound().build();
    }

}
