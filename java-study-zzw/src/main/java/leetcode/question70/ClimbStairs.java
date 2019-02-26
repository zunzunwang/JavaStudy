package leetcode.question70;

public class ClimbStairs {
    public int climbStairs(int n) {
        if(n < 2){
            return n;
        }
        int[] result = new int[n];
        result[0] = 1;
        result[1] = 2;
        for (int i=2; i < n; i++){
            result[i] = result[i-2] + result[i-1];
        }
        return result[n-1];
    }

    public int climbStairsNotSave(int n) {
        if(n < 2){
            return n;
        }
        int start = 1;
        int end= 2;
        for (int i=2; i < n; i++){
            end += start;
            start =  end - start;
        }
        return end;
    }
}
