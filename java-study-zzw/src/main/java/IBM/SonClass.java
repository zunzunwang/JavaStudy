package IBM;

public class SonClass extends FatherClass {
    public String value = setValue();
    private  int i = 10;

    static {
        System.out.println("SonClass of static block");
    }

    public static String male = setMale();

    public SonClass(){
        System.out.println("SonClass of constracutor");
        super.m();
        m();
    }

    private static String setMale(){
        System.out.println("woman of static value");
        return "woman";
    }

    //@Override 这里会重写父类的方法， 让父类的成员函数值改变
    public String setValue(){
        System.out.println("daughter value of not static value");
        return "daughter value";
    }

    //子类重写了父类的方法， 使得父类中引用m的地方全都变成子类的函数。
    public void m(){
        System.out.println("SubClass.m(): i = " + i);
    }

    public void  getFatherValue(){
        System.out.println(super.value);
    }

    public static void main(String args[]){
        SonClass sc;
        System.out.println("-------------- new ---------------");
        sc = new SonClass();
        sc.getFatherValue();
        System.out.println(sc.value);
    }
}
