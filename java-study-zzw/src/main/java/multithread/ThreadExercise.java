package multithread;

/**
 * ThreadExercise is an example to realize a multi-thread by inheritance of Thread class.
 */

public class ThreadExercise extends Thread {
    //each class have to contain a thread.
    private Thread td;
    private String threadName;

    public ThreadExercise(String threadName) {
        this.threadName = threadName;
        System.out.println("Thread: " + threadName + " is created.");
    }

    public void run() {
        try {
            for (int i = 0; i < 4; i++) {
                System.out.println("Thread name " + threadName + " run " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Thread" + threadName + "is interrupted.");
        }
        System.out.println("Thread " + threadName + "has existed.");
    }

    public void start() {
        System.out.println("Thread " + threadName + "start.");
        if (td == null) {
            td = new Thread(this, threadName);
            td.start();
        }
    }

    public static void main(String[] args) {
        ThreadExercise t1 = new ThreadExercise("thread1");
        t1.start();
        ThreadExercise t2 = new ThreadExercise("thread2");
        t2.start();
        ThreadExercise t3 = new ThreadExercise("thread3");
        t3.start();
        ThreadExercise t4 = new ThreadExercise("thread4");
        t4.start();
    }
}
