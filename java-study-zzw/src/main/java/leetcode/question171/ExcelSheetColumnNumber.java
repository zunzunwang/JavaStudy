package leetcode.question171;

/**
 * Created by zunzunwang
 * Date: 25/06/2022
 *
 * Given a string columnTitle that represents the column title as appears in an Excel sheet,
 * return its corresponding column number.
 *
 * For example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *
 * Example 1:
 *
 * Input: columnTitle = "A"
 * Output: 1
 * Example 2:
 *
 * Input: columnTitle = "AB"
 * Output: 28
 * Example 3:
 *
 * Input: columnTitle = "ZY"
 * Output: 701
 *
 *
 * Constraints:
 *
 * 1 <= columnTitle.length <= 7
 * columnTitle consists only of uppercase English letters.
 * columnTitle is in the range ["A", "FXSHRXW"].
 *
 *
 */
public class ExcelSheetColumnNumber {

    public int titleToNumber(String columnTitle) {
        if (columnTitle == null || columnTitle.length() > 7) {
            return 0;
        }
        int coefficient = 26;
        Double result = 0.00;

        for (int i = columnTitle.length() - 1; i >= 0; i-- ){
            // [ZY]
            // i = 1; ("Y" - "A" + 1) * 26^(2-1-1) + 0;
            // i = 0; ("Z" - "A" + 1) * 26^(2-0-1) + value
            result = (columnTitle.charAt(i) - 'A' + 1) * Math.pow(coefficient, columnTitle.length() - i - 1) + result;
        }

        return result.intValue();
    }

    public static void main(String[] args){
        ExcelSheetColumnNumber excelSheetColumnNumber = new ExcelSheetColumnNumber();
        System.out.println(excelSheetColumnNumber.titleToNumber("ZY"));
        System.out.println(excelSheetColumnNumber.titleToNumber("AB"));
        System.out.println(excelSheetColumnNumber.titleToNumber("A"));
    }

}
