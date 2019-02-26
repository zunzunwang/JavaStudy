package SingletonDemo;

public class DCLSingleton {
    //声明成 volatile在java1.5以后使用 每次提取instance是从内存中直接读取而不是从本地的cache中读取
    //禁止指令重排序优化bytecode
    private volatile static DCLSingleton instance;
    private DCLSingleton(){
    }

    /**
     * 双重检验锁模式（double checked locking pattern），是一种使用同步块加锁的方法。
     * 程序员称其为双重检查锁，因为会有两次检查 instance == null，
     * 一次是在同步块外，一次是在同步块内。
     * 为什么在同步块内还要再检验一次？因为可能会有多个线程一起进入同步块外的 if，
     * 如果在同步块内不进行二次检验的话就会生成多个实例了。
     * @return
     */
    public static DCLSingleton getInstance(){
        if (instance == null){
            synchronized (DCLSingleton.class) {
                if (instance == null){
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }

}
