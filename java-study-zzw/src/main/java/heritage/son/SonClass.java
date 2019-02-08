package heritage.son;

import heritage.father.FatherClass;

public class SonClass extends FatherClass{
    public String name = "Son";
    //如果在子类中声明了成员变量无论是否是静态的， 则都会覆盖掉父类的声明和定义。jvm会给默认的变量值。
    //如果不声明则会直接引用到父类的静态变量。而非静态变量由于必须实例化才能使用， 所以不会改变父类。
    public static String valueStaticMentioned;

    static{
        System.out.println("son static code area.");
    }

    //protected int age;
    //String work = "student";
    //private String money = "Dollar";

    @Override
    public void relax(){
        System.out.println("I'm son, I play game for relaxing.");
    }



    public void getFatherName() {
        System.out.println(super.name);
    }

    //@Override 静态方法在子类中不能被重写 但是可以被重新声明。
    public static void wc() {System.out.println("I'm son, I go to wc");}

    public static void main(String[] args){
        System.out.println(SonClass.valueStaticNotMentioned);

        /*
        //First case, son correspond SonClass
        SonClass sc = new SonClass();
        System.out.println("I'm son static value, I have been mentioned but not init. So I'm " + sc.valueStaticMentioned);
        System.out.println("I'm father static not mentioned: " + FatherClass.valueStaticNotMentioned);
        sc.valueStaticNotMentioned = "20";
        System.out.println("I'm father static not mentioned but changed in son: " + FatherClass.valueStaticNotMentioned);

        //无论声明与否都不会改变父类的成员函数的值。
        sc.valueNotStatic = "I'm not static son";
        FatherClass fc1 = new FatherClass();
        System.out.println(fc1.valueNotStatic);
        System.out.println(sc.valueNotStatic);
        System.out.println(sc.age);
        System.out.println(sc.name);
        //default can't be reached in different packages. protected 的范围比default要大。
        //可以在同一个包或者子类， 而default 只能是在同一个包。
        //if we want to use it. have to create their own element.
        //System.out.println(sc.work);

        sc.relax();
        sc.getFatherName();
        sc.wc();

        System.out.println("-------------------------------------------");
        */
    }
}
