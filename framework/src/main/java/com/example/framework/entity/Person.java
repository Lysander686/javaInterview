package com.example.framework.entity;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Data
@Component("person")
public class Person {
    @Value("TestPerson")
    private String name;
    @Value("1")
    private long id;

    @Autowired
    @Qualifier("dog")
    private Pet pet;

    public void call() {
        pet.move();
    }


}
