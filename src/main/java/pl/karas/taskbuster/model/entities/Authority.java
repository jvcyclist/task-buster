package pl.karas.taskbuster.model.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "authorities")
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force=true)
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String username;
    @NotNull
    private String authority;


}
