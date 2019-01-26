package leetcode.question27;


/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1)
 * extra memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int p = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                nums[p++] = nums[i];
                res++;
            }
        }
        return res++;
    }

    public static void main(String[] args) {

    }
}
