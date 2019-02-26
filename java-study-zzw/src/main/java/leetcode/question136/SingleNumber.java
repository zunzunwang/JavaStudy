package leetcode.question136;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
//20/02/2019
public class SingleNumber {
    //basic solution. 使用hashmap帮助存储。 复杂度是o(n)。
    public int singleNumber(int[] nums) {
        //verify the input.
        if(nums.length % 2 == 0){
            return 0;
        }

        Map<Integer, Integer> map = new HashMap();

        if(nums.length == 1){
            return nums[0];
        }

        for(int i = 0; i< nums.length; i++){
            if(map.containsKey(nums[i])){
                map.remove(nums[i]);
            } else {
                map.put(nums[i], 1);
            }
        }

        //rest just one result.
        Set s = map.keySet();
        return (int) s.iterator().next();
    }

    //考察异或操作符。^。一个数 a ^ a = 0. a ^ 0 = a.
    public int singleNumberOptimise(int[] nums) {
        //verify the input.
        if(nums.length % 2 == 0){
            return 0;
        }

        for(int i = 1; i< nums.length; i++){
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
}
