package pl.karas.taskbuster.model.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    private Integer sprint_id;
    private Integer priority;
    private Integer storyPoints;

    @Enumerated(EnumType.STRING)
    private Progress progress;

    /*@ManyToOne
    private User assignedUser;

    @ManyToOne
    private User reporterUser;*/



    public enum Progress{
        BACKLOG, TODO,IN_PROGRESS, QA, DONE;
    }
}


