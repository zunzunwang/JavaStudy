package leetcode.question9;

import java.util.HashMap;
import java.util.Map;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 */
public class Solution {
    public boolean isPalindrome(int x) {
        int temp = x;
        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        } else {

            int result = 0;
            while (x != 0) {
                int last = x % 10;
                result = result * 10 + last;
                x = x / 10;

            }
            return (result == x);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome(121));
        System.out.println(s.isPalindrome(123));


    }
}
