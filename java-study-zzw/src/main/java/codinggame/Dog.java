package codinggame;

/**
 * Created by zunzunwang
 * Date: 08/06/2022
 * 既是抽象类，当然也不能实例化。
 */
public class Dog extends Animal{
    @Override
    String getName() {
        return "getName";
    }

    public static void main(String[] args) {
        Dog d = new Dog();
        System.out.println(d.getName());
    }



}
