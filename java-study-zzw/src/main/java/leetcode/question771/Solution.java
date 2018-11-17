package leetcode.question771;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numJewelsInStones(String J, String S) {

        //when the two string are null, return directly.
        int res = 0;
        if (J == null || J.length() == 0 || S == null || S.length() == 0) {
            return res;
        }

        //way1.
        /*
        Map<Character, Integer> m = new HashMap<>();
        for (int i=0; i<J.length(); i++){
            m.put(J.charAt(i), 0);
        }

        for (int j=0; j<S.length(); j++){
            if (m.containsKey(S.charAt(j))) {
                m.put(S.charAt(j), m.get(S.charAt(j)) + 1);
            }
        }
        return m.values().stream().mapToInt(value -> value).sum();
        */

        //way2.
        int[] hash = new int[256];
        for (int i=0; i<J.length(); i++){
            hash[J.charAt(i)]++;
        }

        for (int j=0; j<S.length(); j++){
            if (hash[S.charAt(j)] > 0) {
                res ++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(s.numJewelsInStones("z", "ZZZZ"));


    }
}
