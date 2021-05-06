package pl.karas.taskbuster.model.entities;


public class Task {

    private Long id;

    private String name;

    private String description;

    private Sprint sprint;

    private Integer storyPoints;

   //User neeedeeed
    //@Enumerated
    private Progress progress;

    public enum Progress{
        BACKLOG, TODO,IN_PROGRESS, QA, DONE;
    }
}


