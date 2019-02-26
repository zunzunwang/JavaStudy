package leetcode.question125;

import java.util.Stack;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int startIndex = 0;
        int endIndex = s.length() - 1;

        while (startIndex <= endIndex) {
            while ((startIndex < s.length()) && !Character.isLetterOrDigit(s.charAt(startIndex))) {
                if (endIndex >= startIndex) {
                    startIndex++;
                } else {
                    return true;
                }
            }

            while (!Character.isLetterOrDigit(s.charAt(endIndex))) {
                if (endIndex >= startIndex) {
                    endIndex--;
                } else {
                    return true;
                }
            }

            if (Character.toLowerCase(s.charAt(startIndex)) == Character.toLowerCase(s.charAt(endIndex))) {
                startIndex++;
                endIndex--;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println('Z' + 1);
        Character c1 =  new Character ('c');
        Character c2 =  new Character ('c');
        Character c3 =  'c';
        Character c4 =  'c';

        System.out.println(c1 == c2);
        //因为c3和c4是在常量池中的。所以为相等。
        System.out.println(c3 == c4);


    }
}
