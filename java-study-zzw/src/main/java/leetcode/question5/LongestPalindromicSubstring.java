package leetcode.question5;

/**
 * Created by zunzunwang
 * Date: 2019-02-27
 * <p>
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 */

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Input: "cbbd"
 * Output: "bb"
 */

/**
 * 使用马拉车算法
 * Manacher算法
 * https://segmentfault.com/a/1190000008484167
 */

public class LongestPalindromicSubstring {
    /*
    public String longestPalindrome(String s) {
        //init
        if(s == null || s.length() == 0){
            return "";
        }


    }
    */

    public static String longestPalindrome(String s) {
        int n = s.length();
        String res = null;

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }

    /*
    public static String longestPalindromeManacher(String string) {
        //init
        if (string == null || string.length() == 0) {
            return "";
        }

        //-----------------------------------
        //转换字符串 遍历循环原字符串，形成新的字符串
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#");
        for (int i = 0; i < string.length(); i++) {
            stringBuilder.append(string.charAt(i));
            stringBuilder.append("#");
        }

        //-----------------------------------
        //answer最大时的中心
        int index = 0;
        //求len中的最大
        int answer = 0;

        //用于保存最远边界和最远边界对应的对称中心。
        int rightIndex = 0;
        int centerIndex = 0;

        //存储需要的用的结果。
        int len[] = new int[stringBuilder.length()];


        for (int i = 1; i < stringBuilder.length(); i++) {
            //当rightIndex > i，那么我们就在rightIndex - i 与len[2 * centerIndex - i](len[j])，取得最小值
            //因为当i + len[j] < rightIndex时，我们就把len[i]更新为len[j]
            //但是如果i + len[j] >= rightIndex时，我们暂且将len[i]定更新为rightIndex - i,超出的部分需要我们一个一个的匹配
            if (rightIndex > i) {
                len[i] = Math.min(rightIndex - i, len[2 * centerIndex - i]);
            } else {
                len[i] = 1;
            }
            //一个一个匹配
            //要么是超出的部分，要么是i > rightIndex
            while (i - len[i] >= 0 && i + len[i] < stringBuilder.length() && stringBuilder.charAt(i - len[i]) == stringBuilder.charAt(i + len[i])) {
                len[i]++;
            }

            //当 len[i] + i > rightIndex,我们需要更新centerIndex和rightIndex
            //至于为什么会这样做，理解一下rightIndex和centerIndex的含义
            if (len[i] + i > rightIndex) {
                rightIndex = len[i] + i;
                centerIndex = i;
            }

            //更新最大字串的中心
            if (len[i] > answer) {
                answer = len[i];
                index = i;
            }
        }
        //截取字符串
        //为什么index - answer + 1,因为len[i] - 1才是原来的回文字符串长度，而answer记录的是len中最大值
        return stringBuilder.substring(index - answer + 1, index + answer).replace("#", "");
    }
    */

    public static String longestPalindrome2(String string) {
        //init
        if(string == null || string.length()==0){
            return "";
        }

        //pre-process string
        StringBuilder sb = preProcess(string);

        //create result len
        int[] len = new int[sb.length()];

        //create anwser
        int answer = 0;
        int answerIndex = 0;

        //create max right and index
        //maxRight not included in
        int maxRight = 0;
        int centerIndex = 0;

        //loop for i=1 to n because we don't calculate the first.
        for(int i=1;i<sb.length()-1;i++){
            //compare with mirror position.
            if(i<maxRight){
                len[i] = Math.min(len[2*centerIndex - i], maxRight-i);
            } else {
                len[i] = 1;
            }

            //check elements beyond maxRight border。
            //i + len[i] 对应的是maxRight 即是对称的外边界。
            while(sb.charAt(i - len[i]) == sb.charAt(i + len[i])){
                len[i]++;
            }

            //update the maxRight and centerIndex
            if(i + len[i] > maxRight){
                maxRight = i + len[i];
                centerIndex = i;
            }

            //update the answer
            if(len[i] > answer){
                answer = len[i];
                answerIndex = i;
            }
        }

        return sb.substring(answerIndex - answer +1, answerIndex + answer).replace("#", "");

    }

    /**
     * 如果这里给开头结尾都添加了特殊符号。 则需要在循环的过程中循环到sb.length() - 1。的长度 不循环最后一个。
     * @param string
     * @return
     */
    public static StringBuilder preProcess(String string){
        StringBuilder sb = new StringBuilder();
        sb.append("$");
        sb.append("#");
        for(int i=0; i< string.length(); i++){
            sb.append(string.charAt(i));
            sb.append("#");
        }
        sb.append("@");
        return sb;
    }

    public static boolean checkPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        for (int start = 0, end = s.length() - 1; start <= s.length() / 2; start++, end--) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome2("babad"));

        String s = "qsd";
    }
}
