package com.example.interview.c8.thread;

public class ThreadTest {
    public static void main(String[] args) {
        Thread t = new Thread() {
            public void run() {
                attack();
            }
        };

        System.out.println("current main thread is: " + Thread.currentThread().getName());

//        t.run();
        // 通过main Thread 创建一个新的thread
        t.start();

    }

    private static void attack() {
        System.out.println("Fight");
        System.out.println(" Current thread is :" + Thread.currentThread().getName());
    }
}
