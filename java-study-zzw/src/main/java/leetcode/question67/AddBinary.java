package leetcode.question67;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder s = new StringBuilder();
        int jinwei = 0;
        int length = Math.max(a.length(), b.length());
        for (int i = 1; i <= length; i++) {
            int current = 0;
            char aChar = a.length() - i >= 0 ? a.charAt(a.length() - i) : '0';
            char bChar = b.length() - i >= 0 ? b.charAt(b.length() - i) : '0';
            if (aChar == '1')
                current++;
            if (bChar == '1')
                current++;
            current += jinwei;
            if (current > 1) {
                jinwei = 1;
                s.append(current % 2);
            } else {
                jinwei = 0;
                s.append(current);
            }
        }
        if (jinwei == 1)
            s.append(1);
        return s.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println('1' + '1');
    }
}
