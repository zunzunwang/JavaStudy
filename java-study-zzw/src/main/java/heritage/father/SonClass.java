package heritage.father;

public class SonClass extends FatherClass{

    public void getFatherName() {
        System.out.println(super.name);
    }

    public static void main(String[] args){

        //First case, son correspond SonClass
        SonClass sc = new SonClass();
        System.out.println(sc.age);
        System.out.println(sc.name);


        //default can't be reached in different packages.
        System.out.println(sc.work);


        sc.relax();
        sc.getFatherName();
        System.out.println("-------------------------------------------");

        //Second case
        FatherClass fc = new heritage.son.SonClass();
        System.out.println(fc.name);
        //age is protected so in this case, We have to look into the definition of fc.
        // age for fc is a protected element, so we can't accept it here.
        System.out.println(fc.age);

        //default can't be reached in different packages.
        //System.out.println(fc.work);

        fc.relax();
        fc.cook();
        //Declaring to FatherClass, so we can't see the function eat();
        //fc.eat();
    }
}
