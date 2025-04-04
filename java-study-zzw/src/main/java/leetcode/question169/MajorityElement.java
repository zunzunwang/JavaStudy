package leetcode.question169;

import java.util.Arrays;

/**
 * Created by zunzunwang
 * Date: 25/09/2019
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */


public class MajorityElement {
    /**
     * solution1: 暴力循环两次 计算出所有元素出现的次数
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     */

    /**
     * solution2 利用HashMap来解决
     * 时间复杂度为 O(n)
     * 空间复杂度为 O(n)
     * 因为至少占用 n/2+1个元素
     */

    /**
     * solution3 利用排序
     * 在数组中，如果一个元素的数量大于 n/2 则经过排序后
     * 一定会出现在 n/2
     * 时间复杂度O(nlgn) 最快的排序
     * 空间复杂度：
     * Space complexity : O(1) or (O(n)
     * 取决于算法
     */

    /**
     * solution4 两头元素进行删除
     * 因为是
     *
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
