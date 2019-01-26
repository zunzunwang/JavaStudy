package leetcode.question38;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 38. Count and Say
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 */
public class Solution {
    public String countAndSay(int n) {
        String init = "1";
        for (int i = 1; i < n; i++) {
            init = treat(init);
        }
        return init;
    }

    private String treat(String s) {
        char c = s.charAt(0);
        int n = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (c == s.charAt(i)) {
                n++;
            } else {
                sb.append(n).append(c);
                c = s.charAt(i);
                n = 1;
            }
        }
        sb.append(n).append(c);
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countAndSay(2));
        System.out.println(s.countAndSay(3));
        System.out.println(s.countAndSay(4));
        System.out.println(s.countAndSay(5));
    }
}
