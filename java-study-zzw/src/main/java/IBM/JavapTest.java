package IBM;

/**
 * Created by zunzunwang
 * Date: 09/10/2019
 */
public class JavapTest {
    public int calculate(){
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) {
        JavapTest jt = new JavapTest();
        System.out.println(jt.calculate());
    }
}
