package leetcode.question66;

import java.util.Stack;

public class PlusOne {
    /*
    public static int[] plusOne(int[] digits) {
        Stack<Integer> s = new Stack();
        boolean plusOne = true;
        int i = digits.length - 1;
        while (i >= 0) {
            if (plusOne) {
                if (decimalPlusOne(digits[i]) != 0) {
                    plusOne = false;
                }
                s.push(decimalPlusOne(digits[i]));
            } else {
                s.push(digits[i]);
            }
            i--;
        }
        if (plusOne) {
            s.push(1);
        }
        int size = s.size();
        int[] result = new int[size];

        for (int j = 0; j < size; j++) {
            result[j] = s.pop();
            System.out.println(result[j]);
        }
        return result;
    }

    private static int decimalPlusOne(int i) {
        if (i + 1 == 10) {
            return 0;
        } else {
            return i + 1;
        }
    }
    */
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if(digits[i] < 9){
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }

        int[] result = new int[n+1];
        result[0] = 1;
        return result;
    }


    public static void main(String[] args) {
        System.out.println(PlusOne.plusOne(new int[]{1, 2, 3}));
        System.out.println(PlusOne.plusOne(new int[]{9, 9, 9}));

    }
}
