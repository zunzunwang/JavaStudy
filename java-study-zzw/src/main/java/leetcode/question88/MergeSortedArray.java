package leetcode.question88;

import java.util.Arrays;

public class MergeSortedArray {
    /**
     * 合并两个已经排序的数组。 num1，num2。 已知num1的size大于等于num1.size + num2.size
     * 不能用二分法解。
     * 原因1。虽然每次可以查找 但是会在头部插入的时候产生问题 因为如果始终是在最头部插入， 他总会将
     * nums1后面的元素向后移动。造成错误。
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //边界条件


        int nums1Index = m - 1;
        int nums2Index = n - 1;
        int resultIndex = m + n - 1;

        while (nums1Index >= 0 && nums2Index >= 0) {
            if (nums1[nums1Index] > nums2[nums2Index]) {
                nums1[resultIndex--] = nums1[nums1Index--];
            } else {
                nums1[resultIndex--] = nums2[nums2Index--];
            }
        }

        while (nums2Index >= 0) {
            nums1[resultIndex--] = nums2[nums2Index--];
        }
    }


    public static int binarySearch(int[] ary, int x, int endIndex) {
        int start = 0;
        int end = endIndex;

        //手写二分法 第一个条件为 <= 用于处理最后一次循环到 start = end的情况。
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (x > ary[mid]) {
                start = mid + 1;
            } else if (x < ary[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -(start + 1);
    }


    public static int binarySearch(int[] arrays, int x) {
        int start = 0;
        int end = arrays.length - 1;

        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (arrays[mid] < x) {
                start = mid + 1;
            } else if (arrays[mid] > x) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -(start + 1);
    }


    public static void main(String[] args) {
        int[] arrays = new int[]{2, 4, 5};
        //System.out.println(Arrays.binarySearch(arrays, 7));
        System.out.println(binarySearch(arrays, 7));
        //int[] num1 = new int[]{1,2,3,0,0,0};
        //int[] num2 = new int[]{2,5,6};
        int[] num1 = new int[]{4, 5, 6, 0, 0, 0};
        int[] num2 = new int[]{1, 2, 3};

        //merge(num1, 3, num2, 3);
    }
}
