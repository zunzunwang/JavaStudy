package SingletonDemo;

public class StaticNestedSingleton {
    /**
     * 首先创建一个私有的静态的内部类
     */
    private static class SingletonHolder{
        //和饿汉一样是直接加载并且是final的
        private static final StaticNestedSingleton INSTANCE = new StaticNestedSingleton();
    }

    private StaticNestedSingleton(){};

    //一个 static final的方法
    public static StaticNestedSingleton getInstance(){
        return SingletonHolder.INSTANCE;
    }

}
