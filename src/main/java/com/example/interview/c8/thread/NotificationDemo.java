package com.example.interview.c8.thread;

import com.example.interview.c8.thread.web.threadPool.Task;

import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class NotificationDemo {
    private volatile boolean go = false;

    public static void main(String[] args) throws InterruptedException {
        final NotificationDemo test = new NotificationDemo();
        final String WAITING_STATUS = "WAITING";

        Runnable waitTask = new Runnable() {
            @Override
            public void run() {
                try {
                    test.shouldGo();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("---" + Thread.currentThread().getName() + " finished Execution");
            }
        };

        // 3 tasks in total
        Thread t1 = new Thread(waitTask, "WT1");
        Thread t2 = new Thread(waitTask, "WT2");
        Thread t3 = new Thread(waitTask, "WT3");


        Task notifyTask = new Task("notifyTask") {
            @Override
            public void run() {
                super.run();
                test.go();
//                System.out.println(Thread.currentThread().getName() + " finished Execution");
            }
        };


        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);

        //starting all waiting thread
        t1.start();
        t2.start();
        t3.start();

        //pause to ensure all waiting thread started successfully
        Thread.sleep(20);


        String[] arr;
        boolean hasTask = false;
        do {
            arr = new String[]{t1.getState().toString(), t2.getState().toString(), t3.getState().toString()};

            if (Arrays.asList(arr).contains(WAITING_STATUS)) {
                hasTask = true;
                System.out.println(Arrays.toString(arr));
                threadPool.execute(notifyTask);

            } else {
                hasTask = false;
            }
            Thread.sleep(500);
        } while (hasTask);

        /*结束主进程*/
        System.exit(0);
    }

    /**
     * wait and notify can only be called from synchronized method or block
     */
    private synchronized void shouldGo() throws InterruptedException {

        while (!go) {
            System.out.println(Thread.currentThread()
                    + " is going to wait on this object");
            wait(); //release lock and reacquires on wakeup
            System.out.println(Thread.currentThread() + " is woken up");
        }
        go = false; //resetting condition
    }

    /**
     * both shouldGo() and go() are locked on current object referenced by "this" keyword
     */
    private synchronized void go() {
        while (!go) {
            System.out.println(Thread.currentThread()
                    + " is going to notify all or one thread waiting on this object");

            go = true; //making condition true for waiting thread
            //notify(); // only one out of three waiting thread WT1, WT2,WT3 will woke up
            notifyAll(); // all waiting thread  WT1, WT2,WT3 will woke up
        }

    }
}
