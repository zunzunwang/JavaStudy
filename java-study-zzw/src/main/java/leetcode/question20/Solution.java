package leetcode.question20;

import com.apple.eawt.SystemSleepListener;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Input: "{[]}"
 * Output: true
 * <p>
 * Input: "([)]"
 * Output: false
 */

public class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0)
            return true;

        if (s.length() == 1)
            return false;
        Map<String, Integer> m = new HashMap<>();
        m.put("(", 1);
        m.put(")", -1);
        m.put("{", 2);
        m.put("}", -2);
        m.put("[", 3);
        m.put("]", -3);

        boolean result = false;

        Stack<String> st = new Stack<>();
        String[] sArray = s.split("");
        for (int i = sArray.length - 1; i >= 0; i--) {
            if (!st.empty()) {
                System.out.print("\ntest " + sArray[i] + st.peek());
                if (m.get(sArray[i]) * m.get(st.peek()) > 0 && m.get(sArray[i]) > 0) {
                    break;
                } else if (m.get(sArray[i]) * m.get(st.peek()) > 0 && m.get(sArray[i]) < 0) {
                    System.out.print("\nin " + sArray[i]);
                    st.push(sArray[i]);
                } else if (m.get(sArray[i]) * m.get(st.peek()) < 0
                        && Math.abs(m.get(sArray[i])) == Math.abs(m.get(st.peek()))
                        && m.get(sArray[i]) > m.get(st.peek())) {
                    System.out.print("\nout " + st.peek());
                    st.pop();
                } else {
                    break;
                }
            } else {
                System.out.print("\nin " + sArray[i]);
                st.push(sArray[i]);
            }
        }

        if (st.empty())
            result = true;

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("{[]}"));
        System.out.println(s.isValid("([)]"));

    }
}
