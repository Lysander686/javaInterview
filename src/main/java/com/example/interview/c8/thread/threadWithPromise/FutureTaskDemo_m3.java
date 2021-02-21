package com.example.interview.c8.thread.threadWithPromise;

import com.example.interview.c8.thread.MyCallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo_m3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 确保线程已经执行完毕
        FutureTask<String> task = new FutureTask<>(new MyCallable());
        new Thread(task).start();
        if (!task.isDone()) {
            System.out.println("Task not finished.");
        }


        System.out.println("task return: " + task.get());
    }

    public static class CycleWait implements Runnable {
        private String value;

        public static void main(String[] args) throws InterruptedException {
            CycleWait cw = new CycleWait();
            Thread t = new Thread(cw);
            t.start();
    //        while (cw.value == null){
    //            Thread.currentThread().sleep(100);
    //        }
            t.join();
            System.out.println("value : " + cw.value);
        }

        public void run() {
            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            value = "we have data now";
        }
    }
}
