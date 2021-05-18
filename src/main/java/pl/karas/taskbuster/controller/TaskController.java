package pl.karas.taskbuster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.karas.taskbuster.model.entities.Sprint;
import pl.karas.taskbuster.model.entities.Task;
import pl.karas.taskbuster.service.SprintService;
import pl.karas.taskbuster.service.TaskService;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TaskController {

    TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public ResponseEntity getAllTasks(){
        Iterable<Task> allTasks = taskService.findAll();

        return allTasks.iterator().hasNext() ?
                ResponseEntity.ok(allTasks)
                : ResponseEntity.badRequest().body("Not found tasks");
    }

    @GetMapping("/task/{id}")
    public ResponseEntity getTaskById(@PathVariable("id") String id){
        Optional<Task> taskById = taskService.findById(Long.valueOf(id));

        return taskById.isPresent() ?
                ResponseEntity.ok(taskById.get())
                : ResponseEntity.badRequest()
                .body("Task with given id not found");
    }

}
