package multithread;

/**
 * RunnableExercise is an example to realize a multi-thread by Runnable interface.
 * pay attention to run() and start() function.
 */

public class RunnableExercise implements Runnable {
    //each class have to contain a thread.
    private Thread td;
    private String threadName;

    //constructor will initiate the threadName;
    public RunnableExercise(String threadName) {
        this.threadName = threadName;
        System.out.println("Thread: " + threadName + " is created.");
    }

    //run function iteration with 4 loop, each loop the thread will sleep 50s;
    public void run() {
        try {
            for (int i = 0; i < 4; i++) {
                System.out.println("thread name: " + threadName);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("thread: " + threadName + " is interrupted.");
        }
        System.out.println("thread: " + threadName + " is interrupted.");
    }

    //start function will create the thread and make it to ready.
    public void start() {
        System.out.println("Thread start: " + threadName);
        if (td == null) {
            td = new Thread(this, threadName);
            td.start();
        }
    }

    public static void main(String [] args) {
        RunnableExercise r1 =  new RunnableExercise("thread1");
        r1.start();
        RunnableExercise r2 =  new RunnableExercise("thread2");
        r2.start();
        RunnableExercise r3 =  new RunnableExercise("thread3");
        r3.start();
        RunnableExercise r4 =  new RunnableExercise("thread4");
        r4.start();
    }
}
