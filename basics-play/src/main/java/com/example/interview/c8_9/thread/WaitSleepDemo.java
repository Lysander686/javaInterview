package com.example.interview.c8_9.thread;

import lombok.SneakyThrows;

public class WaitSleepDemo {
    public static void main(String[] args) {

        final Object lock = new Object();
        Thread threadA = new Thread(new Runnable() {

            @SneakyThrows
            @Override
            public void run() {
                System.out.println("thread A is waiting to get lock");
                // synchronized 获得锁
                synchronized (lock) {
                    System.out.println("thread A get lock");
                    Thread.sleep(20);
                    System.out.println("thread A do wait method");

                    // wait(timeOut), give up the lock, only when the lock is get( e.g. via synchronized keyword
                    lock.wait(500);


                    System.out.println("thread A is done. ");

                }
            }
        });

        threadA.start();

        // 保证上面的代码比下面的代码 先执行 START
        try {
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 保证上面的代码比下面的代码 先执行 END


        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread B is waiting to get lock");
                synchronized (lock) {
                    try {
                        System.out.println("thread B get lock");
                        System.out.println("thread B is sleeping 10 ms");
                        Thread.sleep(10);

                        lock.notify();
                        System.out.println("thread B is done");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        threadB.start();


    }
}
