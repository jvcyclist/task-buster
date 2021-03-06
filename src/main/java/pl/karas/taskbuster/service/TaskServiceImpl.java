package pl.karas.taskbuster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.karas.taskbuster.model.entities.Task;
import pl.karas.taskbuster.repository.TaskRepository;

import java.util.Optional;

@Transactional
@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public Iterable<Task> findAll() {
        return this.taskRepository.findAll();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return this.taskRepository.findById(id);
    }

    @Override
    public Task saveTask(Task task) {
        return this.taskRepository.save(task);
    }

    @Override
    public  Optional<Task> deleteTaskById(Long id) { return this.taskRepository.deleteById(id);}

    @Override
    public Iterable<Task> findAllBySprintId(Integer sprintId) {
        return this.taskRepository.findAllBySprintId(sprintId);
    }
}
