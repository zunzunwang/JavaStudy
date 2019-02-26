package leetcode.Question69;

import java.math.BigDecimal;

public class Sqrt {

    /**
     * 利用牛顿法来逼近 r^2 = x
     * 2r^2 = x + r^2
     * r = (r + x/r)/2
     */
    public static int mySqrt(int x) {
        if (x == 0)
            return 0;
        //这里要使用long是因为i避免了溢出的情况， 否则只能使用二分查找来搜索
        long r = x;
        while (r > x / r) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }

    public static int mySqrtBinarySearch(int x) {
        if (x < 2) {
            return x;
        }

        int start = 0;
        int end = x;
        int mid;
        while (start < end) {
            /**
             * 二分法计算中间值的时候一定不能直接加！！！
             * 会直接溢出！！
             */
            mid = start + (end - start) / 2;
            System.out.println(mid);

            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            } else if (mid > x / mid) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static double mySqrt(double x) {
        double r = x;
        while (r * r - x > 1e-7) {
            System.out.println(r);
            r = (r + x / r) / 2;
        }
        return r;
    }

    public static void main(String[] args) {
        //System.out.println(Sqrt.mySqrt(4.0));
        System.out.println(Sqrt.mySqrtBinarySearch(8));
        //System.out.println(Sqrt.mySqrt(9.0));
    }

}
