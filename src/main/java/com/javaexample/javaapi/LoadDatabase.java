package com.javaexample.javaapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(ContactRepository repository) {
        // create dummy phone number data for initial entries
        List<Phone> numbers_one = Arrays.asList(
                new Phone("804-999-1111", "home"),
                new Phone("804-888-2222", "cell"));
        List<Phone> numbers_two = Collections.singletonList(
                new Phone("804-777-3333", "cell"));
        //
        Contact contact_one = new Contact(
                new Name("John", "Test", "Doe"),
                new Address("10 Dev Street", "Richmond", "Virginia", "23221"),
                numbers_one,
                "john.doe@gmail.com");
        Contact contact_two = new Contact(
                new Name("Jane", "Dee", "Doe"),
                new Address("123 Quality Assurance Lane", "Richmond", "Virginia", "23220"),
                numbers_two,
                "jane.doe@gmail.com");
        // load some initial data into the database
        return args -> {
            log.info("Initial loading " + repository.save(contact_one));
            log.info("Initial loading " + repository.save(contact_two));
        };
    }
}
