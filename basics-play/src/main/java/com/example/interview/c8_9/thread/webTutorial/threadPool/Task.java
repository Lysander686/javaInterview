package com.example.interview.c8_9.thread.webTutorial.threadPool;

import lombok.Getter;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
    @Getter
    private final String name;

    private final boolean toRandomSleep;


    /**
     * @param toRandomSleep default false
     */
    public Task(String name,
                boolean toRandomSleep) {
        this.name = name;
        this.toRandomSleep = toRandomSleep;
    }


    public Task(String name) {
        this(name, false);
    }


    public void run() {
        try {
            long duration = (long) (Math.random() * 10);
//            System.out.println("Executing : " + name);
            if (toRandomSleep)
                TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}