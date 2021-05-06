package pl.karas.taskbuster.service;

import pl.karas.taskbuster.model.entities.Sprint;

import java.util.Optional;

public interface SprintService {

    public Iterable<Sprint> findAll();
    public Optional<Sprint> findById(Long id);

}
