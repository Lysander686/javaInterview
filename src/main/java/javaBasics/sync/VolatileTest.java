package javaBasics.sync;

public class VolatileTest {
    public volatile int inc = 0;

    public static void main(String[] args) {
        System.out.println("start running...");
        final VolatileTest test = new VolatileTest();
        for (int i = 0; i < 1; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 2; j++)
                        test.increase();
                }

                ;
            }.start();
        }

        while (Thread.activeCount() > 1)  //保证前面的线程都执行完
            Thread.yield();

        System.out.println(test.inc);
        System.out.println("End");

    }

    public void increase() {
        inc++;
    }
}