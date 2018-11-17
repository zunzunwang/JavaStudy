package leetcode.question7;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * String reverse can use directly StringBuffer(string).reverse().toString();
 */
public class Solution {
    public int reverse(int x) {
        /*
        if ((x >= 0) && (x <= 9)) {
            return x;
        }
        else if (x > 9) {
            Integer i = x;
            char[] c = i.toString().toCharArray();
            char[] resChar = new char[c.length];
            for (int j = 0; j < c.length; j++) {
                resChar[c.length - j - 1] = c[j];
            }
            try{
                return Integer.parseInt(new String(resChar));
            } catch (Exception e){
                return 0;
            }
        } else {
            Integer i = -x;
            char[] c = i.toString().toCharArray();
            char[] resChar = new char[c.length +1];
            resChar[0] = '-';
            for (int j = 0; j < c.length; j++) {
                resChar[c.length - j] = c[j];
            }
            try{
                return Integer.parseInt(new String(resChar));
            } catch (Exception e){
                return 0;
            }
        }
        */

        //way2.
        int res = 0, y = 0, temp = 0;
        while (x != 0) {
            y = x % 10;
            temp = res;
            res = y + res * 10;
            x = x / 10;
        }

        if ((res - y) / 10 != temp)
            return 0;
        else
            return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverse(-123));
        System.out.println(s.reverse(2147483647));
        int a = Integer.MAX_VALUE;
        System.out.print(a + 1);

        String string="abcdefgh";
        System.out.println("\n" +  new StringBuffer(string).reverse().toString());
    }
}
