package SingletonDemo;

/**
 * http://wuchong.me/blog/2014/08/28/how-to-correctly-write-singleton-pattern/
 * 这段代码简单明了，而且使用了懒加载模式，但是却存在致命的问题。
 * 当有多个线程并行调用 getInstance() 的时候，就会创建多个实例。也就是说在多线程下不能正常工作。
 */

public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton(){
    }

    //不加锁，多线程不安全。
    /*
    public static LazySingleton getInstance(){
        if (instance == null){
            instance = new LazySingleton();
        }

        return instance;
    }
    */

    //为了解决多线程的调用问题 可以加上synchronized锁

    /**
     * 虽然做到了线程安全，并且解决了多实例的问题，但是它并不高效。因为在任何时候只能有一个线程调用 getInstance() 方法。
     * 但是同步操作只需要在第一次调用时才被需要，即第一次创建单例实例对象时。这就引出了双重检验锁。
     * @return
     */
    public static synchronized LazySingleton getInstance(){
        if (instance == null){
            instance = new LazySingleton();
        }

        return instance;
    }
}
