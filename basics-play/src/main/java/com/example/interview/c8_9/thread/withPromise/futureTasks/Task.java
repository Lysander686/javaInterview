package com.example.interview.c8_9.thread.withPromise.futureTasks;

import java.util.concurrent.Callable;

public class Task implements Runnable, Callable<String> {
    public String result;
    public int sleepTime;


    public Task(String result, int sleepTime) {
        this.result = result;
        this.sleepTime = sleepTime;
    }

    public Task(String result) {
        this.result = result;
        this.sleepTime = 1000;
    }

    public void run() {
        this.result = String.valueOf(System.currentTimeMillis());
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(this.sleepTime);
        return this.result;
    }
}