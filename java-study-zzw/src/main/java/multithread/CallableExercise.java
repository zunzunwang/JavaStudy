package multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * This is an example of callable.
 * usually the Future and FutureTask will work with ExecutorService.
 * ExecutorService take a Callable instance and return a Future.
 * or directly take a Runnable instance (here means FutureTask).
 */

public class CallableExercise {

    public List getResult(List<FutureTask<Integer>> futureTasks) {
        // TODO Auto-generated method stub
        List result = new ArrayList();
        for (FutureTask<Integer> futureTask : futureTasks) {
            try {
                while (true) {
                    if (futureTask.isDone() && !futureTask.isCancelled()) {
                        //System.out.println("Future:" + future + ",Result:" + future.get());
                        result.add(futureTask.get());
                        break;
                    } else {
                        Thread.sleep(1000);
                    }
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return result;
    }

    private static Integer getResult(Future<Integer> future) {
        try {
            while (true) {
                if (future.isDone() && !future.isCancelled()) {
                    System.out.println("result of task." + future.get());
                    return future.get();
                } else {
                    Thread.sleep(500);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }


    private static Integer getResult(FutureTask<Integer> futureTask) {

        try {
            while (true) {
                if (futureTask.isDone() && !futureTask.isCancelled()) {
                    System.out.println("result of task." +futureTask.get());
                    return futureTask.get();
                } else {
                    Thread.sleep(500);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void main(String[] args) {
        /**
         * The 3 functions of future:
         * 1. Detect the task has finished or not.
         * 2. Interrupt the task.
         * 3. Get the result of the task.
         *
         * Two ways to get the result: use future or futureTask.
         * FutureTask -[implement]-> RunnableFuture -[extends]-> Runnable and Future
         * FutureTask is the implement class of future.
         *
         * ExecutorService.submit() return a Future.
         * Future have:
         * Callable -> V call()
         * cancel()
         * isCancelled()
         * isDone()
         * get(): blocking method. So before use it please use isCancelled and isDone to make sure the status.
         *
         * FutureTask implement RunnableFuture.
         */

        // Way 1: use Future.
        int threadNum = 2;
        ExecutorService es = Executors.newFixedThreadPool(threadNum);
        CallableTask ct = new CallableTask();
        Future<Integer> result = es.submit(ct);
        es.shutdown();

        try {
            System.out.println("Main thread is working.");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        getResult(result);


        //Way 2: use FutureTask
        ExecutorService es2 = Executors.newCachedThreadPool();
        CallableTask ct2 = new CallableTask();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(ct2);
        es2.submit(futureTask);
        es2.shutdown();

        //or use Thread to start.
        /*
        Thread td = new Thread(futureTask);
        td.start();
        */

        try {
            System.out.println("Main thread is working");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getResult(futureTask);
    }
}
