package javaBasics.sync;

public class SynchronizedTest {
    public int inc = 0;

    public static void main(String[] args) {
        System.out.println("start...");
        final SynchronizedTest test = new SynchronizedTest();
        // create 10 threads
        for (int i = 0; i < 3; i++) {

            new Thread() {
                public void run() {
                    // in every thread, increase test for 1000 times
                    for (int j = 0; j < 10; j++){
                        System.out.println(Thread.currentThread().getName() + " modifying");
                        test.increase();

                    }
                }

                ;
            }.start();
        }

        while (Thread.activeCount() > 1)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);
        System.out.println("main");
    }

    public synchronized void increase() {
        inc++;
    }
}