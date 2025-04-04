package leetcode.question6;

/**
 * Created by zunzunwang
 * Date: 26/06/2022
 *
 *The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 *
 */
public class ZigzagConversion {

    public String convert(String s, int numRows) {
        //if numRows = 1; return string
        if(numRows == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        //print the first line
        for (int index = 0; (2 * numRows - 2) * index < s.length(); index++){
            sb.append(s.charAt((2 * numRows - 2) * index));
        }

        //print the middle line
        for (int d = numRows -2; d > 0; d--){
            int index = 0;
            while (true){
                System.out.println("while");
                if((numRows-1) + (2 * numRows - 2) * index - d < s.length()) {
                    System.out.println("left: " + ((numRows-1) + (2 * numRows - 2) * index - d));
                    sb.append(s.charAt((numRows-1) + (2 * numRows - 2) * index - d));
                } else {
                    break;
                }

                if((numRows-1) + (2 * numRows - 2) * index + d < s.length()) {
                    System.out.println("right: " + ((numRows-1) + (2 * numRows - 2) * index + d));
                    sb.append(s.charAt((numRows-1) + (2 * numRows - 2) * index + d));
                } else {
                    break;
                }
                index ++;
            }
        }

        //print last ligne
        for (int index = 0; (numRows-1) + (2 * numRows - 2) * index < s.length(); index++){
            sb.append(s.charAt((numRows-1) + (2 * numRows - 2) * index));
        }

        //return string;
        return sb.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion zigzagConversion = new ZigzagConversion();
        System.out.println(zigzagConversion.convert("PAYPALISHIRING", 3));
        System.out.println(zigzagConversion.convert("PAYPALISHIRING", 4));
        System.out.println(zigzagConversion.convert("A", 1));




    }



}
