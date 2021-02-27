package com.example.framework.entity;


import lombok.Data;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Data
//@Component("person")
public class Person {
    private String name;
    private long id;


}
