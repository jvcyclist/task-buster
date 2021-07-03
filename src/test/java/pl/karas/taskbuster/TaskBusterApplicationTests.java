package pl.karas.taskbuster;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.karas.taskbuster.model.entities.Authority;
import pl.karas.taskbuster.model.entities.Sprint;
import pl.karas.taskbuster.model.entities.User;
import pl.karas.taskbuster.service.AuthorityService;
import pl.karas.taskbuster.service.SprintService;
import pl.karas.taskbuster.service.UserService;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;

@SpringBootTest
class TaskBusterApplicationTests {

    private SprintService sprintService;


    @Autowired
    public TaskBusterApplicationTests (SprintService sprintService) {
      this.sprintService = sprintService;
    }

    @Test
    void contextLoads() {
        Date startDate = new GregorianCalendar(2021, Calendar.JUNE, 22).getTime();
        Date endDate = new GregorianCalendar(2021, Calendar.JULY, 2).getTime();


        Iterable<Sprint> sprintsByDateBetween;
        sprintsByDateBetween = this.sprintService.findAllSprintBetweenDatesAndByProjectId(startDate,endDate, 2);
        sprintsByDateBetween.forEach(System.out::println);


    }









}
