package com.example.framework.config;

import com.example.framework.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
public class ApplicationConfig {
    @Bean(name = "person")
    public Person initPerson() {
        Person person = new Person();
        person.setId(1L);

        return person;

    }
}
