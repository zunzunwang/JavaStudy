package SingletonDemo;

/**
 * 饿汉式的创建方式在一些场景中将无法使用：譬如 Singleton 实例的创建是依赖参数或者配置文件的，
 * 在 getInstance() 之前必须调用某个方法设置参数给它，那样这种单例写法就无法使用了。
 */
public class SingletonEager {
    private final static SingletonEager instance = new SingletonEager();

    private SingletonEager(){
    }

    public static SingletonEager getInstance(){
        return instance;
    }
}
