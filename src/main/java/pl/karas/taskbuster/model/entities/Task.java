package pl.karas.taskbuster.model.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "sprint_id", nullable = true)
    private Sprint sprint;
    private Integer storyPoints;
    //@Column(columnDefinition = "enum('BACKLOG', 'TODO', 'IN_PROGRESS', 'QA', 'DONE')")
    @Enumerated(EnumType.STRING)
    private Progress progress;

    public enum Progress{
        BACKLOG, TODO,IN_PROGRESS, QA, DONE;
    }
}


