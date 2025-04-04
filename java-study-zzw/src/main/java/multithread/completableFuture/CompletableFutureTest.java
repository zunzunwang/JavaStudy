package multithread.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by zunzunwang
 * Date: 15/06/2022
 */
public class CompletableFutureTest {

    public static void main(String[] args) {
        System.out.println("-------------------------complete---------------------------");
        CompletableFuture completableFuture = new CompletableFuture();
        try {
            completableFuture.complete("Future's result");
            System.out.println("start get()");
            String result = (String) completableFuture.get();
            System.out.println("finish get()");
            System.out.println(result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        //使用 runAsync() 运行异步计算
        System.out.println("-------------------------runAsync---------------------------");
        CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("start sleep 5s");
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("finish sleep 5s");

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("a separate thread than the main thread.");
            }
        });
        System.out.println("Here is the main thread");
        try {
            System.out.println("Before get()");
            future.get();
            System.out.println("After get()");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

}
