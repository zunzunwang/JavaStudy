package IBM;

public class Singleton {
    private static Singleton instance = new Singleton();
    public static int value1;
    public static int value2 = 0;

    //改变顺序就会影响初始化的结果
    //private static Singleton instance = new Singleton();


    private Singleton(){
        value1++;
        value2++;
    }

    public static Singleton getInstance(){
        return instance;
    }

    public static void main(String args[]){
        System.out.println(Singleton.value1);
        System.out.println(Singleton.value2);
    }
}
