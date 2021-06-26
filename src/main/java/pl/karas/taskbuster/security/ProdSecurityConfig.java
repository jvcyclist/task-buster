package pl.karas.taskbuster.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@Profile("prod")
@Configuration
@EnableWebSecurity
public class ProdSecurityConfig extends WebSecurityConfigurerAdapter {

    private final String API = "api";

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                    .dataSource(dataSource)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

            http.headers().frameOptions().disable();
            http
                    .csrf().disable()
               .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/api/users/**", "/api/user/**").hasAuthority("ROLE_ADMIN")
              //  .antMatchers("/api/tasks/**", "/api/sprints/**").hasAuthority("ROLE_USER")
                .antMatchers("/**").permitAll()
            .and()
                .httpBasic();

    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
