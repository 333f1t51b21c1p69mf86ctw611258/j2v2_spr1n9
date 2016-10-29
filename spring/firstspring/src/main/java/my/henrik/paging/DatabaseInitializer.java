package my.henrik.paging;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import my.henrik.paging.domain.Person;
import my.henrik.paging.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer {

    private PersonService personService;

    @Autowired
    public DatabaseInitializer(PersonService studentService) {
        this.personService = studentService;
    }

    @PostConstruct
    public void populateDatabase() {
        Person firstPerson = new Person("Barack", "Obama", 40);
        Person secondPerson = new Person("Vladimir", "Putin", 50);
        Person thirdPerson = new Person("Jong", "Kim Un", 30);
        Person fourthPerson = new Person("Angela", "Merkel", 60);
        Person fifthPerson = new Person("David", "Cameron", 60);
        Person sixthPerson = new Person(" Alexander", "Lukashenko", 60);

        Person person1 = new Person("Barack", "Obama", 40);
        Person person2 = new Person("Barack", "Obama", 40);
        Person person3 = new Person("Barack", "Obama", 40);
        Person person4 = new Person("Barack", "Obama", 40);
        Person person5 = new Person("Barack", "Obama", 40);
        Person person6 = new Person("Barack", "Obama", 40);
        Person person7 = new Person("Barack", "Obama", 40);
        Person person8 = new Person("Barack", "Obama", 40);
        Person person9 = new Person("Barack", "Obama", 40);

        personService.save(Arrays.asList(
                firstPerson,
                secondPerson,
                thirdPerson,
                fourthPerson,
                fifthPerson,
                sixthPerson,
                person1,
                person2,
                person3,
                person4,
                person5,
                person6,
                person7,
                person8,
                person9)
        );
    }

}
