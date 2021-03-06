package pl.karas.taskbuster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.karas.taskbuster.model.entities.Sprint;
import pl.karas.taskbuster.model.entities.Task;
import pl.karas.taskbuster.repository.SprintRepository;

import java.util.Date;
import java.util.Optional;

@Service
public class SprintServiceImpl implements SprintService {

    private SprintRepository sprintRepository;

    @Autowired
    public SprintServiceImpl(SprintRepository sprintRepository){
        this.sprintRepository = sprintRepository;
    }

    @Override
    public Iterable<Sprint> findAll() {
        return this.sprintRepository.findAll();
    }

    @Override
    public Optional<Sprint> findById(Long id) {
        return this.sprintRepository.findById(id);
    }

    @Override
    public Optional<Sprint> findByCurrentDate(Date currentDate) {
        return this.sprintRepository.findByCurrentDate(currentDate);
    }

    @Override
    public Iterable<Sprint> findAllSprintBetweenDatesAndByProjectId(Date startDate, Date endDate, Integer projectId) {
        return this.sprintRepository.findAllSprintBetweenDatesAndByProjectId(startDate, endDate, projectId);
    }

    @Override
    public Iterable<Sprint> findAllByProjectId(Integer projectId) {
        return this.sprintRepository.findAllByProject_id(projectId);
    }

    @Override
    public Sprint saveSprint(Sprint sprint) {
        return this.sprintRepository.save(sprint);
    }

}
