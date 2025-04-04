package leetcode.question168;

/**
 * Created by zunzunwang
 * Date: 2019-05-03
 */
public class ExcelSheetColumnTitle {
    public static String convertToTitle(int n) {
        //init
        if(n<1){
            return null;
        }

        StringBuilder sb = new StringBuilder();
        int tmp;
        while( n > 0 ){
            tmp = n % 26 == 0 ? 26 : n % 26;
            sb.append((char) (tmp + 64));
            if(n%26 == 0){
                n = n/26 -1;
            } else {
                n = n/26;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle.convertToTitle(52);

    }
}
