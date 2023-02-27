package com.hello.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student Aditya = new Student(
                    "Aditya Sharma",
                    "aditya@gmail.com",
                    LocalDate.of(1998, Month.SEPTEMBER, 20)

            );
            Student Soumen = new Student(
                    "Soumen Patra",
                    "soumen@gmail.com",
                    LocalDate.of(2000, Month.SEPTEMBER, 24)

            );
            repository.saveAll(
                    List.of(Soumen,Aditya)
            );
        };
    }
}
