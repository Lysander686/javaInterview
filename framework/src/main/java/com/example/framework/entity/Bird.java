package com.example.framework.entity;

import org.springframework.stereotype.Component;

@Component("bird")
public class Bird implements Pet {

    @Override
    public void move() {
        System.out.println("Flying");
    }
}
