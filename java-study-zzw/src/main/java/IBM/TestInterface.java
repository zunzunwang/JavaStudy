package IBM;

/**
 * Created by zunzunwang
 * Date: 07/02/2020
 */
public interface TestInterface {

    static void hello(){
        System.out.println("hello world");
    }

    default void bonjour(){
        System.out.println("bonjour");
    }

    public void hola();
}
