package multithread.daemon;

/**
 * In this example, if the main thread finish with out sleep 2000ms, the work of
 * daemon can't be finished. Because if the main thread is finished the jvm will make
 * the daemon thread finish directly however the work haven't finished yet.
 */
public class TestDemo2{
    public static void main(String[] args) throws InterruptedException
    {
        Runnable tr=new TestRunnable();
        Thread thread=new Thread(tr);
        thread.setDaemon(true); //set Daemon.
        thread.start(); //start son thread.
        //Thread.sleep(2000);
        System.out.println("this is main thread.");
    }
}
