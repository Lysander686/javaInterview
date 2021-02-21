package com.example.interview.c8.thread.threadWithPromise;

// 主线程等待法: not recommended
public class MyThread_m1 extends Thread {
    private String value1;
    private String value2;

    public static void main(String[] args) throws Exception {
        MyThread_m1 thread = new MyThread_m1();
        thread.start();
        while (thread.value1 == null || thread.value2 == null) sleep(100);
        System.out.println("value1:" + thread.value1);
        System.out.println("value2:" + thread.value2);
    }

    public void run() {
        value1 = "有数据了";
        value2 = "有数据了";
    }
}  