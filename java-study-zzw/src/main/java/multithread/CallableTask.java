package multithread;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<Integer>{
    public Integer call() throws Exception {
        System.out.print("\nson thread is working.");
        Thread.sleep(3000);
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum = sum + i;
        }
        return sum;
    }
}
