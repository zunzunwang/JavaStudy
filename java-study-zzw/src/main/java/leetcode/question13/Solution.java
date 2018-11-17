package leetcode.question13;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
public class Solution {
    public int romanToInt(String s) {
        int res = 0;
        Map<String, Integer> m = new HashMap<>();
        m.put("N", 0);
        m.put("I", 1);
        m.put("V", 5);
        m.put("X", 10);
        m.put("L", 50);
        m.put("C", 100);
        m.put("D", 500);
        m.put("M", 1000);
        //each time we choose two character
        String[] charArray = (s+"N").split("");
        for (int i = 1; i < charArray.length; i++) {
            if (m.get(charArray[i - 1]) >= m.get(charArray[i])) {
                res += m.get(charArray[i - 1]);
            } else {
                res += (m.get(charArray[i]) - m.get(charArray[i - 1]));
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.romanToInt("IX"));
        System.out.println(s.romanToInt("LVIII"));
        System.out.println(s.romanToInt("MDCXCV"));
    }
}
