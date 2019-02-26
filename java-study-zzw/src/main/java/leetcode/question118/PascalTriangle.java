package leetcode.question118;


import java.util.ArrayList;
import java.util.List;

//17/02/2019
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0){
            return result;
        }

        //init level one.
        List<Integer> levelOne = new ArrayList<>();
        levelOne.add(1);
        result.add(levelOne);

        if (numRows == 1){
            return result;
        }

        for(int i = 1; i < numRows; i ++){
            List<Integer> lastLevel = result.get(i - 1);
            List<Integer> currentLevel = new ArrayList<>();
            //insert first one
            currentLevel.add(1);
            //calculate by lastLevel
            if (lastLevel.size() > 1){
                for (int j = 0; j<lastLevel.size()-1; j++){
                 currentLevel.add(lastLevel.get(j) + lastLevel.get(j+1));
                }
            }
            //insert last one
            currentLevel.add(1);
            result.add(currentLevel);
        }

        return result;
    }
}
