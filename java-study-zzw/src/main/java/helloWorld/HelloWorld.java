package helloWorld;

/**
 * Created by zunzunwang
 * Date: 04/06/2022
 * Quand tu execute le fichier dans le terminal, il faut lancer dans la racine de project.
 * here means /java/..
 */
public class HelloWorld {
    public static void main(String[] str) {
        String a = "a" + "c";
        String b = "b";
        String ab = a+b;
        String ab1 = ab.intern();
        System.out.println(ab == ab1);
    }
}
