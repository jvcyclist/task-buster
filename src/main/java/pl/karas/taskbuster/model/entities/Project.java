package pl.karas.taskbuster.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @JsonManagedReference
    @OneToMany(mappedBy = "project_id")
    private List<Sprint> sprintList;

    @ManyToOne
    @JoinColumn(name = "user_admin_id")
    User adminUser;


//User administrator
//List<User> participant

}
