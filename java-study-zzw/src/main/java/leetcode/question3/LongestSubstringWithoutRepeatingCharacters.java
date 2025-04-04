package leetcode.question3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zunzunwang
 * Date: 2019-02-26
 */

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        //init
        if(s == null || s.length() == 0){
            return 0;
        }

        int start = 0;
        int result = 0;
        Map<Character, Integer> map = new HashMap();
        for(int i=0; i<s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                //这一步确保了， 避免查找到的位置在开头位置之前， 相当于一境舍弃了。
                start = Math.max(start ,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            //用于保存历史最大值
            result = Math.max(i - start +1, result);
        }
        return result;
    }
}
