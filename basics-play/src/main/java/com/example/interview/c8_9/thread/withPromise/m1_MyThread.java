package com.example.interview.c8_9.thread.withPromise;

// 主线程等待法: not recommended
public class m1_MyThread extends Thread {
    private String value1;
    private String value2;

    public static void main(String[] args) throws Exception {
        m1_MyThread thread = new m1_MyThread();
        thread.start();
        while (thread.value1 == null || thread.value2 == null) {
            System.out.println("data not integrated");
            sleep(100);
        }
        System.out.println("value1:" + thread.value1);
        System.out.println("value2:" + thread.value2);
    }

    public void run() {

        value1 = "有数据了";
        value2 = "有数据了";
    }
}  