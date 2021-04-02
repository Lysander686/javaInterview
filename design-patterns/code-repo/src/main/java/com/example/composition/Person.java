package com.example.composition;

public class Person {

    //composition has-a relationship
    private Job job;

    public Person() {
        // Java composition is achieved by using instance variables that refers to other objects.
        this.job = new Job();
        job.setSalary(1000L);
    }

    public long getSalary() {
        return job.getSalary();
    }

}
