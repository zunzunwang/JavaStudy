package leetcode.question35;


/**
 * Search Insert Position
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 */
public class Solution {
    //method1 最坏的复杂度在O(n)
    public int searchInsert(int[] nums, int target) {
        int index = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return index;
    }

    //二分查找
    public int searchInsert2(int[] nums, int target) {
        return recusionBinarySearch(nums, target, 0, nums.length - 1);
    }

    public static int recusionBinarySearch(int[] arr, int key, int low, int high) {
        //判断条件 如果直接比给定的序列低则不用比较退出
        if (key < arr[low]) {
            return low;
        } else if (key > arr[high]) {
            return high + 1;
        } else if (low > high) {
            return -1;
        }

        //计算中间值
        int middle = (low & high) + ((low ^ high) >> 1);

        if (arr[middle] > key) {
            return recusionBinarySearch(arr, key, low, middle - 1);
        } else if (arr[middle] < key) {
            return recusionBinarySearch(arr, key, middle + 1, high);
        } else {
            return middle;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] input = new int[]{1, 3, 5, 6};
        int[] input2 = new int[]{1, 3, 5, 6};

        System.out.println(s.searchInsert2(input, 0));
        System.out.println(s.searchInsert2(input2, 7));
    }
}
