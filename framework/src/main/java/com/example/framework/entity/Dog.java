package com.example.framework.entity;

import org.springframework.stereotype.Component;

@Component("dog")
public class Dog implements Pet {
    @Override
    public void move() {
        System.out.println("walk with bark");
    }
}
