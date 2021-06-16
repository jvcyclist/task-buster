package pl.karas.taskbuster.service;

import pl.karas.taskbuster.model.entities.Authority;

import java.util.Set;

public interface AuthorityService {

    Set<Authority> findAuthoritiesByUserNameAndRole(String username, String authority);
    Authority saveAuthority(Authority authority);


}
