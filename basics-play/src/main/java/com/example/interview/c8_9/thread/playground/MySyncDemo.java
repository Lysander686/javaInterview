package com.example.interview.c8_9.thread.playground;

import com.example.interview.c8_9.thread.SyncThread;
import lombok.SneakyThrows;

public class MySyncDemo {
    @SneakyThrows
    public static void main(String[] args) {
        SyncThread syncThread = new SyncThread(); // st1

        SyncThread st2 = new SyncThread(); // st2

        Thread t1 = new Thread(syncThread, "syncClassBlock");
        Thread t2 = new Thread(st2, "syncClassMethod");

        t1.start();
        t1.join();
        t2.start();

    }

    static void testMethod(String name, String age){

    }

}
