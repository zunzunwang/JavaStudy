package IBM;


public class ClassLoaderTest {
/*
    public static void main(String args[]) throws ClassNotFoundException {

        Class c = Class.forName("java.lang.String");
        //空为根类加载器
        System.out.println(c.getClassLoader());

        //应用加载器 系统类加载器
        Class p = Class.forName("IBM.Price");
        System.out.println(p.getClassLoader());
    }
    */

    public static void main(String args[]){
        System.out.println(Cat.type);
        System.out.println("-----------------------------------");
        System.out.println(Cat.sousType);
        Cat c = new Cat();
        c.getFatherName();

    }
}


class Animal {
    public final static String type="animal";
    public static String sousType = "small animal";
    static {
        System.out.println("animal static init!");
    }
    public String name = getName();

    protected String getName(){
        System.out.println("get name Animal");
        return "Animal";
    }

}

class Cat extends Animal {
    public static String catType="cat";
    static {
        System.out.println("cat static init!");
    }

    @Override
    protected String getName(){
        System.out.println("get name cat");
        return "cat";
    }

    protected void getFatherName(){
        System.out.println(super.name);
    }
}