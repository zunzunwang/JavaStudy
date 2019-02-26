package IBM;

public class ValueTransfer {
    /**
     * java的值传递是值传递。即值变成拷贝值，对象变成对象的指针的拷贝。 所以并没有引用传递。
     * 思考下面问题。
     */

    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        operator(a, b);
        StringBuilder x = new StringBuilder("x");
        StringBuilder y = new StringBuilder("y");
        operator(x, y);
        Integer one = new Integer(1);
        Integer two = new Integer(2);
        operator(one, two);
        System.out.println(a + "," + b);
        System.out.println(x + "," + y);
        System.out.println(one + "," + two);
    }

    public static void operator(String a, String b) {
        System.out.println("传入为值的化只为值的拷贝");
        a += b;
        b = a;
    }

    public static void operator(Integer a, Integer b) {
        System.out.println("传入为值的化只为值的拷贝");
        a += b;
        b = a;
    }

    public static void operator(StringBuilder a, StringBuilder b) {
        System.out.println("传入为对象的化。 是对对象指针的拷贝");
        /**
         * 这一句 改变了指针所指向的object的值
         */
        a.append(b);

        /**
         * 这一句只是改变了所给定的指针的拷贝。 将它指向了a。
         */
        b = a;
        b.append("I'm pointed to you");
    }

}
