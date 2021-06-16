package pl.karas.taskbuster.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.karas.taskbuster.model.entities.Authority;
import pl.karas.taskbuster.repository.AuthorityRepository;

import java.util.Set;




@Service
public class AuthorityServiceImpl implements AuthorityService  {

    private AuthorityRepository authorityRepository;

    @Autowired
    public AuthorityServiceImpl(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    @Override
    public Set<Authority> findAuthoritiesByUserNameAndRole(String username, String authority) {
        return this.authorityRepository.findAllByUsernameAndAuthority(username, authority);
    }

    @Override
    public Authority saveAuthority(Authority authority) {
        return this.authorityRepository.save(authority);
    }

}
