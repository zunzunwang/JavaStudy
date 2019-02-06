package swordoffer;

public class CountBinaryOne {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(Float.MAX_EXPONENT);
        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.MIN_EXPONENT);
        System.out.println(Float.MIN_VALUE);
    }


}
