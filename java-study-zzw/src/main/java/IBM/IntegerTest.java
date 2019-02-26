package IBM;

/**
 * Created by zunzunwang
 * Date: 2019-02-25
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer a = new Integer(200);
        Integer b = new Integer(200);
        Integer c = 200;
        Integer e = 200;
        Integer c1 = 127;
        Integer e1 = 127;

        int d = 200;

        System.out.println("两个new出来的对象    ==判断  (a == b) = " + (a == b)); //false.
        System.out.println("两个new出来的对象    equal判断 a.equals(b) = " + a.equals(b)); //true
        System.out.println("new出的对象和用int赋值的Integer   ==判断 (a == c) = " + (a == c));//false
        System.out.println("new出的对象和用int赋值的Integer   equal判断 (a.equals(c)) = " + (a.equals(c)));//true
        System.out.println("两个用int赋值的Integer    ==判断 (c == e) = " + (c == e));//true
        System.out.println("两个用int赋值的Integer    ==判断 (c1 == e1) = " + (c1 == e1));//true

        System.out.println("两个用int赋值的Integer    equal判断 (c.equals(e))= " + (c.equals(e)));//true
        System.out.println("基本类型和new出的对象   ==判断 (d == a) =" + (d == a));//false
        System.out.println("基本类型和new出的对象   equal判断 (a.equals(d)) = " + (a.equals(d)));//true
        System.out.println("基本类型和自动装箱的对象   ==判断 (d == c) = " + (d == c));//true
        System.out.println("基本类型和自动装箱的对象   equal判断 (c.equals(d)) = " + (c.equals(d)));//true

        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);

        Character cc1 = 'c';
        Character cc2 = 'c';
        Character cc3 = new Character('c');
        System.out.println(cc1 == cc2);
        System.out.println(cc1 == cc3);


    }

}
