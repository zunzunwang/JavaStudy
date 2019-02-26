package leetcode.question53;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int sum = 0, max = nums[0], maxunique = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i] > 0 ? sum + nums[i] : 0;
            max = Math.max(sum, max);
            maxunique = Math.max(nums[i], maxunique);
        }

        return max > 0 ? max : maxunique;
    }

    public static int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int current = 0, global = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            //这一步巧妙的达到了我语句中的如果sum小于零则舍去的作用
            current = Math.max(current + nums[i], nums[i]);
            global = Math.max(global, current);
        }

        return global;
    }

    public static void main(String[] args) {
        System.out.println(MaximumSubarray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(MaximumSubarray.maxSubArray(new int[]{-2, -1, -3, -4, -1, -2, -1, -5, -4}));
        System.out.println(MaximumSubarray.maxSubArray2(new int[]{1,2,-7,-8,5}));
    }
}

