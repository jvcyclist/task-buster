package pl.karas.taskbuster.model.entities;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;


@Entity(name = "users")
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force=true)
public class User {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private String username;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username")
    private Set<Authority> authorities;





}
