package pl.karas.taskbuster.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.karas.taskbuster.entities.Sprint;
import pl.karas.taskbuster.repositories.SprintRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SprintController {

    SprintRepository sprintRepository;

    @Autowired
    public SprintController(SprintRepository sprintRepository){
        this.sprintRepository = sprintRepository;
    }

    @GetMapping("/sprints")
    public ResponseEntity getAllSprints(){
        Iterable<Sprint> allSprints = sprintRepository.findAll();

        return allSprints.iterator().hasNext() ?
                ResponseEntity.ok(allSprints)
                : ResponseEntity.badRequest().body("Not found sprints");
    }

    @GetMapping("/sprint/{id}")
    public ResponseEntity getSprintById(@PathVariable("id") String id){
        Optional<Sprint> sprintById = sprintRepository.findById(Long.valueOf(id));

        return sprintById.isPresent() ?
                ResponseEntity.ok(sprintById.get())
                : ResponseEntity.badRequest()
                .body("Sprint with given id not found");
    }

}
