package multithread.not.safe.thread.demo;

public class Counter {
    protected long count = 0;

    public void add(long value){
        this.count = this.count + value;
    }

    //此处是静态局部变量, 静态局部变量存在栈之中所以是线程安全的
    public void localVariableAdd(){
        long threadSafeInt = 0;
        System.out.println("Read threadSafeInt: " + threadSafeInt);
        threadSafeInt++;
    }
}
