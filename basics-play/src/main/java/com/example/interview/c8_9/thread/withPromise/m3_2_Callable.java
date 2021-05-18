package com.example.interview.c8_9.thread.withPromise;

import java.util.concurrent.*;

// 方法三 之 2:  使用Callable接口实现
public class m3_2_Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建一个线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //创建两个有返回值的任务
        Callable c1 = new MyCallable("A");
        Callable c2 = new MyCallable("B");
        //执行任务并获取Future对象
        Future future1 = executorService.submit(c1);
        Future future2 = executorService.submit(c2);
        //从Future对象上获取任务的返回值，并输出到控制台
        System.out.println(">>>" + future1.get().toString());
        System.out.println(">>>" + future2.get().toString());
        //关闭线程池
        executorService.shutdown();
    }
}

  class MyCallable implements Callable {
      private String oid;

      MyCallable(String oid) {
          this.oid = oid;
      }

      @Override
      public Object call() throws Exception {
          return oid + "任务返回的内容";
      }
}