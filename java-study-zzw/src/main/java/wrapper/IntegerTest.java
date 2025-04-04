package wrapper;

import java.math.BigDecimal;

/**
 * Created by zunzunwang
 * Date: 09/06/2022
 * https://alexyyek.github.io/2014/12/29/wrapperClass/
 * https://www.fangzhipeng.com/javainterview.html
 *
 */
public class IntegerTest {
    private static class Student {
        String name;
        Integer age;
        public Student(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }
    /***
     * Byte: 1 byte = 8 bits [-128,127]
     * Short: 2 bytes
     * Integer: 4 bytes
     * Long: 8 bytes
     * Char:
     */
    public static void main(String[] args) {
        System.out.println("/****************************** Question 1 *********************************/");
        Integer i = 100; //Integer i = Integer.valueOf(100);
        Integer j = 100;
        Integer i1 = 128;
        Integer j1 = 128;
        System.out.println("i1 == j1:" + (i1 == j1)); //false [-128,127] use integerCache.cache;
        System.out.println("i == j:" + (i == j));//true use new Integer;

        System.out.println("/****************************** Question 2 *********************************/");
        Integer i2 = 200;//Autoboxing
        int j2 = 200;
        System.out.println(i2 == j2);//true Unboxing比较intValue

        System.out.println("/****************************** Question 3 *********************************/");
        Integer i3 = 100; //IntegerCache 中的object
        Integer j3 = new Integer(100);
        System.out.println(i3 == j3);//false 因为new出来的永远是object地址比较

        System.out.println("/****************************** Question 4  *********************************/");
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;
        System.out.println(c==d);//true autoboxing and get object from IntegerCache
        System.out.println(e==f);//false autoboxing and get object by new Object.
        System.out.println(c==(a+b));//true(a+b) unboxing so comparing the value true
        System.out.println(c.equals(a+b));//true unboxing to calculate value and autoboxing like integer
        System.out.println(g==(a+b));//true unboxing long compare with an int, auto convertise int to long
        System.out.println(g.equals(a+b));//false a+b autoboxing to Integer not the same type.
        System.out.println(g.equals(a+h));//true a+h autoboxing to Long the same type.
        System.out.println(c.equals(a+h));//false a+h is long autoboxing to Long not the same type with Integer.
        System.out.println(c==(1+2));//true(1+2) unboxing so comparing the value true
        System.out.println(c.equals(1+2));//true (1+2) autoboxing so comparing the Integer
        System.out.println(g.equals(1+2));//false (1+2) autoboxing so comparing the Long
        System.out.println(e == (100+221));//true (1+2) autoboxing so comparing the Integer
        System.out.println(e.equals(100+221));//true (1+2) autoboxing so comparing the Integer

        short s = 1;
        //s + 1 auto convert to int

        System.out.println("/****************************** Question 5  *********************************/");
        Student student1 = new Student("hello", 100);
        Student student2 = new Student("hello", 100);
        Student student3 = new Student("hello", 200);
        Student student4 = new Student("hello", 200);

        System.out.println(student1.age == student2.age);//true
        System.out.println(student3.age == student4.age);//false
        System.out.println(student3.age.equals(student4.age));//true autoboxing to new Integer
        System.out.println(student3.age.equals(200L));//false autoboxing to Long

        System.out.println("/****************************** Question 6  *********************************/");
        Double d6 = 200.00;
        Integer i6 = 200;
        System.out.println(d6.equals(i6));




    }
}
