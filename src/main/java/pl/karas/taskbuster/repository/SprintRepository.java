package pl.karas.taskbuster.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import pl.karas.taskbuster.model.entities.Sprint;


import javax.swing.*;
import java.util.Date;
import java.util.Optional;

@Component
public interface SprintRepository extends CrudRepository<Sprint, Long> {
    
    public Iterable<Sprint> findAll();
    public Optional<Sprint> findById(Long id);

    @Query("SELECT s from Sprint s where s.startDate <= ?1 AND s.endDate >= ?1")
    public Optional<Sprint> findByCurrentDate(Date currentDate);

    @Query("SELECT s from Sprint s where s.startDate between ?1 AND ?2 AND s.project_id = ?3 OR s.endDate between ?1 AND ?2 and s.project_id = ?3")
    public Iterable<Sprint> findAllSprintBetweenDatesAndByProjectId(Date startDate, Date endDate, Long projectId);

}
