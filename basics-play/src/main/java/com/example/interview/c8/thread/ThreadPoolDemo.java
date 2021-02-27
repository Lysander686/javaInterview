package com.example.interview.c8.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        // create thread pool
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        //  给线程池提交任务
        Future<String> future = newCachedThreadPool.submit(new MyCallable());

        if (!future.isDone()) {
            System.out.println("not done  yet");
        }

        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            newCachedThreadPool.shutdown();
        }
    }
}
