package pl.karas.taskbuster.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


public class Sprint {

    private Long id;
    private Date startDate;
    private Date endDate;
    private Integer storyPoints;

}
