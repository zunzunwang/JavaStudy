package algorithme;

public class MoveOperator {
    public static void main(String[] args) {
        int num = -1;
        System.out.println("num : " + Integer.toBinaryString(num));

        int num2 = num >> 10;
        System.out.println(">>  : " + Integer.toBinaryString(num2));

        int num4 = num >>> 10;
        System.out.println(">>> : " + Integer.toBinaryString(num4));

        int num3 = num << 31;
        System.out.println("<<  : " + Integer.toBinaryString(num3));

        System.out.println("int 的范围是 " + Integer.MAX_VALUE + " 到 " + Integer.MIN_VALUE);
        System.out.println("int 的范围是 " + Integer.toBinaryString(Integer.MAX_VALUE) + " 到 " + Integer.toBinaryString(Integer.MIN_VALUE));

        //最大值加一 就会变成最小值 最高位为符号位
        //任何值移动31位之后就只剩符号位
        //偶数移动31位只剩0在符号为 所以为0
        //奇数移动31位只剩1在符号位 所以位 最小int
        //根据这个规则，左移32位后，右边补上32个0值是不是就变成了十进制的0了？答案是NO，当int类型进行左移操作时，
        // 左移位数大于等于32位操作时，
        //会先求余（%）后再进行左移操作。
        System.out.println("1移动31位 " + Integer.toBinaryString(1 << 31) + " " + (1 << 31));
        System.out.println("1移动32位 " + Integer.toBinaryString(1 << 32) + " " + (1 << 32));
        System.out.println("1移动33位 " + Integer.toBinaryString(1 << 33) + " " + (1 << 33));

        System.out.println("2移动31位 " + Integer.toBinaryString(2 << 31) + " " + (2 << 31));
        System.out.println("2移动32位 " + Integer.toBinaryString(2 << 32) + " " + (2 << 32));
        System.out.println("2移动33位 " + Integer.toBinaryString(2 << 33) + " " + (2 << 33));



    }
}
