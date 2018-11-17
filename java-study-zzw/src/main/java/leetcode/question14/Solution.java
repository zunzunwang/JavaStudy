package leetcode.question14;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(!(strs.length > 0)){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int[] hash = new int[256];
        label:
        for (int i=0; i< strs[0].length(); i++){
            hash[strs[0].charAt(i)] = strs[0].charAt(i);
            int lastChar = strs[0].charAt(i);
            for (String str : strs) {
                if ( (str.length()-1 < i) || hash[str.charAt(i)] != lastChar){
                    break label;
                }
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.longestCommonPrefix(new String[]{"abca","aba","aaab"}));

    }
}
