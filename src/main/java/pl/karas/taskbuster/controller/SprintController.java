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
    public ResponseEntity getAllSprints(){
        Iterable<Sprint> allSprints = sprintService.findAll();

        return allSprints.iterator().hasNext() ?
                ResponseEntity.ok(allSprints)
                : ResponseEntity.badRequest().body("Not found sprints");
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


}
