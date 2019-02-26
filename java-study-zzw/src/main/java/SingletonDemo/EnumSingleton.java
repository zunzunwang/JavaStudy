package SingletonDemo;

public enum  EnumSingleton {
    //定义了一个枚举元素， 极为实例
    INSTANCE;

    public void doSomeThing(){
        //do something;
    }

    public static void main(String args[]) {
        EnumSingleton singleton = EnumSingleton.INSTANCE;
        singleton.doSomeThing();
    }
}
