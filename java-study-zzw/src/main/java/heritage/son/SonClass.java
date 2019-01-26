package heritage.son;

import heritage.father.FatherClass;

public class SonClass extends FatherClass{
    public String name = "Son";
    //protected int age = 16;
    //String work = "student";
    //private String money = "Dollar";

    @Override
    public void relax(){
        System.out.println("I'm son, I play game for relaxing.");
    }

    public void eat(){
        System.out.println("I'm son, I eat food.");
    }

    public void getFatherName() {
        System.out.println(super.name);
    }

    public static void main(String[] args){
        //First case, son correspond SonClass
        SonClass sc = new SonClass();
        System.out.println(sc.age);
        System.out.println(sc.name);

        //default can't be reached in different packages.
        //if we want to use it. have to create their own element.
        //System.out.println(sc.work);


        sc.relax();
        sc.getFatherName();
        System.out.println("-------------------------------------------");

        //多态的条件：
        //继承 重写 父类引用指向子类对象

        //Second case
        FatherClass fc = new SonClass();
        System.out.println(fc.name);
        //age is protected so in this case, We have to look into the definition of fc.
        // age for fc is a protected element, so we can't accept it here.
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
