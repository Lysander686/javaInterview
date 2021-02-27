package com.example.framework;

import com.example.framework.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan
public class FrameworkApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = (ApplicationContext) SpringApplication.run(FrameworkApplication.class);
        Person person = ctx.getBean(Person.class);
        System.out.println(person.toString());
    }

}
