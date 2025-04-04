package concurrent;

/**
 * Created by zunzunwang
 * Date: 10/06/2022
 */
public class ConcurrentTest {
    /**
     * 并发concurrent
     * 并行parallel
     * synchronized 防止多个线程同时执行同一段代码。
     * https://blog.csdn.net/asd136912/article/details/106243585
     */

    /**
     * volatile mark a java variable:
     * read from the main memory not from the cpu cache.
     * write to main memory not just to thread cache
     *
     * AtomicInteger incrementAndGet decrementAndGet
     */


    public static void main(String[] args) {
        /**
         * Atomic: un operation couldn't be stopped at the middle.
         */
        int x = 10;//atomic
        int y = x;//no
        x++;//no
        x= x + 1;//no

        /**
         * voltaire operation sur ce variable est atomic.
         * 对变量的写操作不依赖当前值或其余的值
         */


    }
}
