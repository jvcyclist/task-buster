package pl.karas.taskbuster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.karas.taskbuster.model.entities.Sprint;
import pl.karas.taskbuster.repository.SprintRepository;

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
}
