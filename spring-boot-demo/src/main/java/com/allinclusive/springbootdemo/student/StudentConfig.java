package com.allinclusive.springbootdemo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.util.Calendar.JANUARY;

@Configuration
public class StudentConfig {
    CommandLineRunner commandLineRunner(StudentRepo studentRepo){
        return args -> {
             Student lucia = new Student(
                "Lucia",
                "lucy@gmail.com" ,
                LocalDate.of(2000, JANUARY, 5)
        );
            Student alex = new Student(
                    "alex",
                    "alex@gmail.com" ,
                    LocalDate.of(2001, JANUARY, 5)
            );
            Student reg = new Student(
                    "reg",
                    "reg@gmail.com" ,
                    LocalDate.of(2002, JANUARY, 5)
            );
            studentRepo.saveAll(List.of(lucia, alex, reg));
        };
    }
}
