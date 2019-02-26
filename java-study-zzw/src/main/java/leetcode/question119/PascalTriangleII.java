package leetcode.question119;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//18/02/2019获取帕斯卡三角形的某一层计算结果。
public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        List<Integer> resultHelp = new ArrayList<>();
        if (rowIndex == 0) {
            return result;
        }

        result.add(1);
        if (rowIndex == 1) {
            return result;
        }

        for (int i = 1; i <= rowIndex; i++) {
            resultHelp = result;
            result.clear();
            //insert first one
            result.add(1);
            //calculate by lastLevel
            if (resultHelp.size() > 1) {
                for (int j = 0; j < resultHelp.size() - 1; j++) {
                    result.add(resultHelp.get(j) + resultHelp.get(j + 1));
                }
            }
            //insert last one
            result.add(1);
        }

        return result;


    }

    public List<Integer> getRowOptimise(int rowIndex) {
        //List<Integer> result = new ArrayList<>();
        Integer[] result = new Integer[rowIndex + 1];
        Arrays.fill(result, 0);
        result[0] = 1;

        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; 0 < j; j--){
                result[j] += result[j-1];
            }
        }
        return Arrays.asList(result);
    }


    public static void main(String[] args) {
        Integer[] test = new Integer[3];
        System.out.println(test[0]);
    }


}
