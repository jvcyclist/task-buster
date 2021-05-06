package pl.karas.taskbuster.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.karas.taskbuster.model.entities.Sprint;
import pl.karas.taskbuster.repository.SprintRepository;
import pl.karas.taskbuster.service.SprintService;

import java.util.Optional;

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

    @GetMapping("/sprint/{id}")
    public ResponseEntity getSprintById(@PathVariable("id") String id){
        Optional<Sprint> sprintById = sprintService.findById(Long.valueOf(id));

        return sprintById.isPresent() ?
                ResponseEntity.ok(sprintById.get())
                : ResponseEntity.badRequest()
                .body("Sprint with given id not found");
    }

}
