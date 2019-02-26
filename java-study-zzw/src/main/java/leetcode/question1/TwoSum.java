package leetcode.question1;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        /*
        for (int i = 0; i <= nums.length - 2; i++) {
            for (int j = i + 1; j <= nums.length - 1; j++) {
                if ((nums[i] + nums[j]) == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
        */

        //way2. for case there isn't duplicated element in this array.
        Map<Integer, Integer> m = new HashMap<>();
        for (int i=0; i< nums.length; i++) {
            if (m.containsKey(target - nums[i])) {
                return new int[]{m.get(target - nums[i]), i};
            } else {
                m.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum s = new TwoSum();
        int[] nums = new int[]{3, 2, 4};
        int[] res = s.twoSum(nums,6);
        System.out.println(res[0] + " " + res[1]);
    }
}
