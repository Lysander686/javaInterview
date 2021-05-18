package javaAdvanced.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    //value1：线程不安全
    private static int value1 = 0;
    //value2：使用乐观锁
    private static AtomicInteger value2 = new AtomicInteger(0);
    //value3：使用悲观锁
    private static int value3 = 0;

    private static synchronized void increaseValue3() {
        value3++;
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executors = Executors.newFixedThreadPool(4);
        int threadNumber = 1000;
        final CountDownLatch countDownLatch = new CountDownLatch(threadNumber);

        //开启1000个线程，并执行自增操作
        for (int i = 0; i < threadNumber; ++i) {
            executors.execute(() -> {
                try {
                    Thread.sleep(1);
                    value1++;
                    value2.getAndIncrement();
                    increaseValue3();
                    // System.out.println("finished");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        //打印结果
        countDownLatch.await();
        System.out.println("线程不安全：" + value1);
        System.out.println("乐观锁(AtomicInteger)：" + value2);
        System.out.println("悲观锁(synchronized)：" + value3);
    }
}