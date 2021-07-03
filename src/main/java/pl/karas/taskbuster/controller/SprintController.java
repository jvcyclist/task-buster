package pl.karas.taskbuster.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.karas.taskbuster.model.entities.Sprint;
import pl.karas.taskbuster.model.entities.Task;
import pl.karas.taskbuster.repository.SprintRepository;
import pl.karas.taskbuster.service.SprintService;

import java.util.Date;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class SprintController {

    SprintService sprintService;

    @Autowired
    public SprintController(SprintService sprintService){
        this.sprintService = sprintService;
    }

    @GetMapping("/sprints")
    public ResponseEntity getAllSprints(@ModelAttribute(name = "projectId") String projectId){

        if(!projectId.isEmpty()){

            Iterable<Sprint> allSprintsByProjectId = sprintService.findAllByProjectId(Integer.valueOf(projectId));

            return allSprintsByProjectId.iterator().hasNext() ?
                    ResponseEntity.ok(allSprintsByProjectId)
                    : ResponseEntity.badRequest().body("Not found sprints for given Project Id");
        }
        else{
            Iterable<Sprint> allSprints = sprintService.findAll();

            return allSprints.iterator().hasNext() ?
                    ResponseEntity.ok(allSprints)
                    : ResponseEntity.badRequest().body("Not found sprints");
        }
    }

    @GetMapping("/sprints/current")
    public ResponseEntity getCurrentSprint(){
        Date currentDate = new Date(System.currentTimeMillis());
        Optional<Sprint> sprintByCurrentDate = sprintService.findByCurrentDate(currentDate);

        return sprintByCurrentDate.isPresent() ?
                ResponseEntity.ok(sprintByCurrentDate)
                : ResponseEntity.badRequest().body("Not found sprints");
    }

    @GetMapping("/sprints/{id}")
    public ResponseEntity getSprintById(@PathVariable("id") String id){
        Optional<Sprint> sprintById = sprintService.findById(Long.valueOf(id));

        return sprintById.isPresent() ?
                ResponseEntity.ok(sprintById.get())
                : ResponseEntity.badRequest()
                .body("Sprint with given id not found");
    }

    @PostMapping("/sprints")
    public ResponseEntity<Sprint> addSprint(@RequestBody Sprint sprint){
       Iterable<Sprint> sprints =  this.sprintService.findAllSprintBetweenDatesAndByProjectId(
               sprint.getStartDate(),
                sprint.getEndDate(),
                sprint.getProject_id());

       if(sprints.iterator().hasNext()){
           return ResponseEntity.badRequest().build();
       }
        else{
           this.sprintService.saveSprint(sprint);
           return ResponseEntity.ok(sprint);
       }
    }

}
