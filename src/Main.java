import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);
        ExecutorService executor1 = Executors.newSingleThreadExecutor();
        ExecutorService executor2 = Executors.newFixedThreadPool(1);
        ExecutorService executor3 = Executors.newScheduledThreadPool(3);

        MyPrintIntegerCollectionTask task1 = new MyPrintIntegerCollectionTask(integers);
        MyFindAverageTask task2 = new MyFindAverageTask(integers);
        MyFindSumTask task3 = new MyFindSumTask(integers);
        MyFindMaxTask task4 = new MyFindMaxTask(integers);
        MyFindMinTask task5 = new MyFindMinTask(integers);

        Future<?> result1 = executor1.submit(task1);
        Future<Double> resultAverage1 = executor1.submit(task2);
        Future<Integer> resultSum1 = executor1.submit(task3);
        Future<Integer> resultMax1 = executor1.submit(task4);
        Future<Integer> resultMin1 = executor1.submit(task5);

        try {
            System.out.println("\n +++++++ Watching on SingleThreadExecutor working:");
            double average = resultAverage1.get();
            int sum = resultSum1.get();
            int min = resultMin1.get();
            int max = resultMax1.get();
            result1.get();
            System.out.println("Summary of Integer Collection: " + sum +
                    "\nAverage in Collection: " + average +
                    "\nMin in Collection: " + min +
                    "\nMax in Collection: " + max);
            System.out.println(" ------- End of work. Thanks for attention.");
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Task is failed");
            e.printStackTrace();
        }

        Future<?> result2 = executor2.submit(task1);
        Future<Double> resultAverage2 = executor2.submit(task2);
        Future<Integer> resultSum2 = executor2.submit(task3);
        Future<Integer> resultMax2 = executor2.submit(task4);
        Future<Integer> resultMin2 = executor2.submit(task5);

        try {
            System.out.println("\n +++++++ Watching on NewFixedThreadPool working:");

            double average = resultAverage2.get();
            int sum = resultSum2.get();
            int min = resultMin2.get();
            int max = resultMax2.get();
            result2.get();
            System.out.println("Summary of Integer Collection: " + sum +
                    "\nAverage in Collection: " + average +
                    "\nMin in Collection: " + min +
                    "\nMax in Collection: " + max);
            System.out.println(" ------- End of work. Thanks for attention.");
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Task is failed");
            e.printStackTrace();
        }

        Future<?> result3 = executor3.submit(task1);
        Future<Double> resultAverage3 = executor3.submit(task2);
        Future<Integer> resultSum3 = executor3.submit(task3);
        Future<Integer> resultMax3 = executor3.submit(task4);
        Future<Integer> resultMin3 = executor3.submit(task5);

        try {
            System.out.println("\n +++++++ Watching on NewScheduledThreadPool working:");

            double average = resultAverage3.get();
            int sum = resultSum3.get();
            int min = resultMin3.get();
            int max = resultMax3.get();
            result3.get();
            System.out.println("Summary of Integer Collection: " + sum +
                    "\nAverage in Collection: " + average +
                    "\nMin in Collection: " + min +
                    "\nMax in Collection: " + max);
            System.out.println(" ------- End of work. Thanks for attention.");
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Task is failed");
            e.printStackTrace();
        }

        MyAnalyzeCpuTask task6 = new MyAnalyzeCpuTask();
        Future<?> result6 = executor1.submit(task6);

        try {
            System.out.println(" ...Expect...");
            result6.get();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Task is failed");
            e.printStackTrace();
        }

        try {
            System.out.println("...Are my task is done??...");
            while (!result6.isDone()) {
                System.out.println("...");
            }
        } catch (Exception e) {
            System.out.println("Isn't done...");
            e.printStackTrace();
        }
    }
}
