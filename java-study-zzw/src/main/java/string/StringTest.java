package string;

/**
 * Created by zunzunwang
 * Date: 14/06/2022
 */
public class StringTest {
    //https://www.cnblogs.com/iyangyuan/p/4631696.html

    //jvm为String常量池来提高性能, String是immutable的
    //https://www.cnblogs.com/Andya/p/14067618.html
    /**
     * String constant pool is like a cash
     * when you create the String at the constant pool, we will check if it exists already
     * at the constant pool.
     * if existed, we will return it, else create the string and put it in constant pool.
     *
     *
     *
     *
     */

    /**
     * String hashcode
     * 31 * h + val[i];
     */
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = "Hel" + "lo";
        String s4 = "Hel" + new String("lo");
        String s5 = new String("Hello");
        String s6 = s5.intern();
        String s7 = "H";
        String s8 = "ello";
        String s9 = s7 + s8;

        System.out.println(s1 == s2);  // true 编译期间字符串会直接放入class文件的常量池中从而实现复用
        System.out.println(s1 == s3);  // true 编译优化 将hel + lo 合并成 hello
        System.out.println(s1 == s4);  // false s4保存在堆内存
        System.out.println(s1 == s9);  // false s9 保存在堆内存
        System.out.println(s4 == s5);  // false 两者都在堆内存中
        System.out.println(s1 == s6);  // true intern方法将向常量池中添加常量

        String s10 = new String("Test");
        String s11 = s10.intern();
        String s12 = "Test";
        System.out.println(s11 == s12); // true 都在常量池之中

        String s13 = new String("ad") + "ad";
        System.out.println(s13);


        /**
         *   public string.StringObject();
         *     Code:
         *        0: aload_0
         *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         *        4: return
         *
         *   public static void main(java.lang.String[]);
         *     Code:
         *        0: ldc           #2                  // String ab
         *        2: astore_1
         *        3: return
         */
        String str = "a" + "b";


        /**
         *          Code:
         *          0: aload_0
         *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         *          4: return
         *
         *          public static void main(java.lang.String[]);
         *          Code:
         *          0: new           #2                  // class java/lang/String
         *          3: dup
         *          4: ldc           #3                  // String ab
         *          6: invokespecial #4                  // Method java/lang/String."<init>":(Ljava/lang/String;)V
         *          9: astore_1
         *          10: return
         */
        String s = new String("a" + "b");




        /**
         *  Question 1.
         */
        System.out.println("----------------------Question 1-------------------------");
        String aa = "aa";
        String aa1 = new String("aa");
        aa1.intern();//"aa" already exist at the String constant pool.
        System.out.println(aa == aa1);//false because "aa" is at String constant pool. aa1 is a new object.

        /**
         *  Question 2.
         */
        System.out.println("----------------------Question 2-------------------------");
        String b = new String("b");
        String bb = new String(b + b);
        bb.intern();//"bb" doesn't exist at the String Constant Pool. create a reference linked to heap object.
        String bbf = "bb";// the reference if the aa2
        System.out.println(bb == bbf);//true


        /**
         * Question 3.
         */
        System.out.println("----------------------Question 3-------------------------");
        String a3 = "a";
        String param = new String("param" + a3);
        param.intern();
        System.out.println(param == "parama");

        /**
         * Question 4.
         */
        System.out.println("----------------------Question 4-------------------------");
        String str4 = "abc" + "def";
        String a4 = "a";
        String b4 = "b";
        String c4 = "c";
        String strTmp = new String(a4 + b4 + c4);
        strTmp.intern();
        System.out.println("abc" == strTmp); //true
    }
}
