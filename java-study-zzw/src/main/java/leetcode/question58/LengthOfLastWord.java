package leetcode.question58;

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty())
            return 0;

        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {

            if (s.charAt(i) != ' ') {

                count++;
            } else {
                if (count > 0){
                    break;
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(LengthOfLastWord.lengthOfLastWord("Hello World"));
        System.out.println(LengthOfLastWord.lengthOfLastWord("a "));
    }
}
