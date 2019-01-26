package multithread.not.safe.thread.demo;

/**
 * In this example, we show a not-safe multi-thread operation.
 * <p>
 * you can find the count value is different during the loop.
 */
public class CounterDemo implements Runnable {
    Thread td;
    String threadName;
    Counter c;
    Integer addValue;

    CounterDemo(String threadName, Counter cr, Integer value) {
        this.threadName = threadName;
        c = cr;
        addValue = value;
    }

    @Override
    public void run() {
        System.out.println("threadName: " + threadName + " add " + addValue);
        c.add(addValue);
        c.localVariableAdd();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        if (td == null) {
            System.out.println("start thread: " + threadName);
            td = new Thread(this, threadName);
            td.start();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("This is main thread.");
            Counter c = new Counter();
            CounterDemo r1 = new CounterDemo("thread1", c, 2);
            r1.start();
            CounterDemo r2 = new CounterDemo("thread2", c, 3);
            r2.start();
            System.out.println(c.count);
        }
    }
}
