package javaAdvanced.conurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SquareCalculator {

    private static ExecutorService executor = Executors.newFixedThreadPool(2);

    // reference: https://www.twle.cn/c/yufei/javatm/javatm-basic-future.html
    public static Future<Integer> calculate(Integer input) {
        System.out.println("calculating square for: "+input);
        return executor.submit(() -> { // Submits a value-returning task for execution and returns a Future representing the pending results of the task.
            Thread.sleep(3000);
            return input * input;
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SquareCalculator squareCalculator = new SquareCalculator();

        Future<Integer> future1 = squareCalculator.calculate(10);
        Future<Integer> future2 = squareCalculator.calculate(100);

        Integer result1 = future1.get();
        System.out.println("r1 done");
        Integer result2 = future2.get();
        System.out.println("r2 done");

        System.out.println(result1 + " and " + result2);

        squareCalculator.shutdown();
    }

    public void shutdown() {
        System.exit(0);
    }
}