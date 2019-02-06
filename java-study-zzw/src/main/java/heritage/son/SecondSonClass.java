package heritage.son;

import heritage.father.FatherClass;

public class SecondSonClass extends FatherClass{
    public static String valueStaticMentioned = "I'm static mentioned son";
    public String valueNotStatic = "I'm not static father";
    public String name = "secondSon";
    protected int age = 10;
    String work;
    private String money;

    public void eat(){
        System.out.println("I'm son, I eat food.");
    }

    @Override
    public void relax(){
        System.out.println("I use local value " + name + ", I play game for relaxing.");
    }


    public static void main(String args[]){
        //多态的条件：
        //继承 重写 父类引用指向子类对象
        //Second case
        FatherClass fc = new SecondSonClass();
        System.out.println(fc.name);
        //age is protected so in this case, We have to look into the definition of fc.
        //age for fc is a protected element, so we can't accept it here.
        //System.out.println(fc.age);

        //default can't be reached in different packages.
        //System.out.println(fc.work);

        fc.relax();

        //
        fc.cook();
        //Declaring to FatherClass, so we can't see the function eat();
        //fc.eat();
    }
}
