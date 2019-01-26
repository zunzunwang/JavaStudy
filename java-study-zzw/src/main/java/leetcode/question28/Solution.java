package leetcode.question28;

/**
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.equals("")) {
            return 0;
        } else if (!haystack.contains(needle)) {
            return -1;
        } else {
            int len = needle.length();
            char[] c = haystack.toCharArray();
            for (int i = 0; i < c.length - len + 1; i++) {
                if (needle.equals(haystack.substring(i, i + len))) {
                    return i;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.strStr("mississippi", "issi"));
        System.out.println(s.strStr("hello", "ll"));
        System.out.println(s.strStr("a", "a"));


    }

}
