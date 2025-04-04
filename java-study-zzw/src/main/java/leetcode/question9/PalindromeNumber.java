package leetcode.question9;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        //negatif number: false;
        if (x < 0) {
            return false;
        }

        int result = 0, original = x;

        while(x/10 > 0) {
            result = result * 10 + x % 10;
            x = x/10;
        }

        result =  result * 10 + x % 10;
        return result == original ? true: false;
    }


    public static void main(String[] args) {
        PalindromeNumber s = new PalindromeNumber();
        System.out.println(s.isPalindrome(121));
        System.out.println(s.isPalindrome(123));


    }
}
