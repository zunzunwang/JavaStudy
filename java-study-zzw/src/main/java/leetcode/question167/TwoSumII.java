package leetcode.question167;

/**
 * Created by zunzunwang
 * Date: 2019-03-04
 */

/**
 * Given an array of integers that is already sorted in ascending order,
 * find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2.
 *
 * Note:
 *
 *     Your returned answers (both index1 and index2) are not zero-based.
 *     You may assume that each input would have exactly one solution and you may not use the same element twice.
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 *
 * 利用有序的特性， 直接从两头开始循环，向中间逼近。
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        //init
        if(numbers == null){
            return null;
        }

        int l = 0;
        int r = numbers.length - 1;

        while(l < r){
            if(numbers[l] + numbers[r] == target){
                return new int[]{l+1, r+1};
            } else if (numbers[l] + numbers[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        return null;
    }
}
