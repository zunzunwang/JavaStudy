package leetcode.question26;

/**
 * Given a sorted array nums, remove the duplicates in-place
 * such that each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array,
 * you must do this by modifying the input array in-place with O(1) extra memory.
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        int p = 0;
        int temp;
        int res = 0;
        if (nums.length > 0) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[p]) {
                    temp = nums[p +1];
                    nums[++p] =  nums[i];
                    nums[i] = temp;
                    res++;
                }
            }
            return  res + 1;
        } else {
            return res;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeDuplicates(new int[]{1, 1, 2}));
    }
}
