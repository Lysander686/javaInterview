package javaAdvanced.conurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SquareCalculator {

    private ExecutorService executor
      = Executors.newSingleThreadExecutor();

    // reference: https://www.twle.cn/c/yufei/javatm/javatm-basic-future.html
    /* rezp: 消费( 使用 ) Future
     */
    public Future<Integer> calculate(Integer input) {
        return executor
                // Submits a value-returning task for execution and returns a Future representing the pending results of the task.
                .submit(() -> {
            Thread.sleep(1000);
            return input * input;
        });
    }
}