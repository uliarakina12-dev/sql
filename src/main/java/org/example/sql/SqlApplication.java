package org.example.sql;

import org.example.sql.entity.Person;
import org.example.sql.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SqlApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(PersonRepository repo) {
        return args -> {
            Person p1 = new Person();
            p1.setName("Alexey");
            p1.setSurname("Petrov");
            p1.setAge(28);
            p1.setPhoneNumber("+79991234567");
            p1.setCity("Moscow");
            repo.save(p1);

            Person p2 = new Person();
            p2.setName("Anna");
            p2.setSurname("Ivanova");
            p2.setAge(30);
            p2.setPhoneNumber("+79998887766");
            p2.setCity("Moscow");
            repo.save(p2);

            Person p3 = new Person();
            p3.setName("Ivan");
            p3.setSurname("Sidorov");
            p3.setAge(40);
            p3.setPhoneNumber("+79995554433");
            p3.setCity("Saint Petersburg");
            repo.save(p3);
        };
    }
}
