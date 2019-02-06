package IBM;

public class FatherClass {
    public String value = setValue();

    static{
        System.out.println("FatherClass of static block");
    }

    //static的静态变量和静态代码块按顺序初始化
    public static String male = setMale();

    public FatherClass(){
        System.out.println("FatherClass of constracutor");
        m();
    }

    public void m(){
        System.out.println("SuperClass.m()");
    }

    private static String setMale(){
        System.out.println("male of static value");
        return "male";
    }

    protected String setValue(){
        System.out.println("Father value of not static value");
        return "father value";
    }

    public static void main(String args[]){
        FatherClass fc;
    }
}
