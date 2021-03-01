package com.example.interview.c8.thread.withPromise;

class ThreadA implements Runnable {
    private int counter;

    @Override
    public void run() {
        while (counter <= 10) {
            System.out.print("Counter = " + counter + " ");
            counter++;
        }
        System.out.println();
    }
}

class ThreadB implements Runnable {

    private int i;

    @Override
    public void run() {
        while (i <= 10) {
            System.out.print("i = " + i + " ");
            i++;
        }
        System.out.println();
    }
}

// 方法二: 使用Thread 的join(),
public class m2_ThreadTester {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ThreadA());
        Thread t2 = new Thread(new ThreadB());
        t1.start();
        t1.join(); // wait t1 to be finished
        t2.start();
        t2.join(); // in this program, this may be removed
    }
}