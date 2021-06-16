package pl.karas.taskbuster.service;

import pl.karas.taskbuster.model.entities.Sprint;
import pl.karas.taskbuster.model.entities.Task;

import java.util.Optional;

public interface TaskService {

    public Iterable<Task> findAll();
    public Optional<Task> findById(Long id);
    public Task saveTask(Task task);
}
