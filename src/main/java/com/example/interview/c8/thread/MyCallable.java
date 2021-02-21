package com.example.interview.c8.thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        String value = "test";
        System.out.println("ready to work");
        // 相当于异步代码
        Thread.currentThread().sleep(1000);
        System.out.println("Task done");
        return value;
    }
}
