package pl.karas.taskbuster.controller;

import antlr.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.karas.taskbuster.model.entities.Sprint;
import pl.karas.taskbuster.model.entities.Task;
import pl.karas.taskbuster.service.SprintService;
import pl.karas.taskbuster.service.TaskService;

import javax.websocket.server.PathParam;
import java.util.Optional;
@CrossOrigin()
@RestController
@RequestMapping("/api")
public class TaskController {

    TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        this.taskService.saveTask(task);
        return ResponseEntity.ok(task);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity getTaskById(@PathVariable("id") String id){
        Optional<Task> taskById = taskService.findById(Long.valueOf(id));

        return taskById.isPresent() ?
                ResponseEntity.ok(taskById.get())
                : ResponseEntity.badRequest()
                .body("Task with given id not found");
    }

    @GetMapping("/tasks")
    public ResponseEntity getTaskBySprintId(@ModelAttribute(value="sprintId") String sprintId){

        if(sprintId.isEmpty()){
            Iterable<Task> allTasks = taskService.findAll();

            return allTasks.iterator().hasNext() ?
                    ResponseEntity.ok(allTasks)
                    : ResponseEntity.badRequest().body("Not found tasks");
        }
        else{
            Iterable<Task> allTasksBySprintId = taskService.findAllBySprintId(Integer.valueOf(sprintId));

            return allTasksBySprintId.iterator().hasNext() ?
                    ResponseEntity.ok(allTasksBySprintId)
                    : ResponseEntity.badRequest().body("Not found tasks with given Sprint ID");
        }
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity updateTask(@PathVariable("id") String id, @RequestBody Task task){
        Optional<Task> taskById = taskService.findById(Long.valueOf(id));
        if(taskById.isPresent()){
            this.taskService.saveTask(task);
            return ResponseEntity.accepted().build();
        }
        else return ResponseEntity.notFound().build();
    }

    @PatchMapping("/tasks/{id}")
    public ResponseEntity updateTaskStatus(@PathVariable("id") String id, @RequestBody Task task){

        Optional<Task> taskById = taskService.findById(Long.valueOf(id));
        if(taskById.isPresent()){
            taskById.get().setProgress(task.getProgress());
            this.taskService.saveTask(taskById.get());
            return ResponseEntity.accepted().build();
        }
        else return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity deleteTask(@PathVariable("id") String id){

        Optional<Task> taskById = taskService.findById(Long.valueOf(id));
        if(taskById.isPresent()){
            this.taskService.deleteTaskById(Long.valueOf(id));
            return ResponseEntity.accepted().build();
        }
        else return ResponseEntity.notFound().build();
    }




}
