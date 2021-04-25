package pl.karas.taskbuster.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Task {


    private Long id;
    private String name;
    private String description;
    //Spring <----
    private Integer storyPoints;
    //Progress enum <----
    //assignedPerson <--- User
    private Progress progress;

    public enum Progress{
        BACKLOG, TODO,IN_PROGRESS, QA, DONE;
    }
}


