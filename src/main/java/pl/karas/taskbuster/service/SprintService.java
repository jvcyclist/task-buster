package pl.karas.taskbuster.service;

import pl.karas.taskbuster.model.entities.Sprint;
import pl.karas.taskbuster.model.entities.Task;

import java.util.Date;
import java.util.Optional;

public interface SprintService {

    public Iterable<Sprint> findAll();
    public Optional<Sprint> findById(Long id);
    public Optional<Sprint> findByCurrentDate(Date currentDate);
    public Iterable<Sprint> findAllByDateBetween(Date startDate, Date endDate);

}
