package algorithme;

import java.util.Arrays;

/**
 * BubbleSort:
 * Bubble sort has a worst-case and average complexity of О(n2), where n is the number of items being sorted.
 * <p>
 * 冒泡排序（英语：Bubble Sort）是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。
 * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
 * 这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
 * <p>
 * <p>
 * 冒泡排序对 n 个项目需要O(n 2)的比较次数，且可以原地排序。
 * 尽管这个算法是最简单了解和实现的排序算法之一，但它对于包含大量的元素的数列排序是很没有效率的。
 * <p>
 * <p>
 * 冒泡排序是与插入排序拥有相等的运行时间，但是两种算法在需要的交换次数却很大地不同。
 * 在最坏的情况，冒泡排序需要 O ( n 2 ) 次交换，
 * 而插入排序只要最多O(n)交换。冒泡排序的实现（类似下面）通常会对已经排序好的数列拙劣地运行 O（n 2），
 * 而插入排序在这个例子只需要 O ( n ) 个运算。因此很多现代的算法教科书避免使用冒泡排序，而用插入排序取代之。
 * 冒泡排序如果能在内部循环第一次运行时，使用一个旗标来表示有无需要交换的可能，也可以把最优情况下的复杂度降低到 O ( n )。
 * 在这个情况，已经排序好的数列就无交换的需要。
 * 若在每次走访数列时，把走访顺序反过来，也可以稍微地改进效率。
 * 有时候称为鸡尾酒排序，因为算法会从数列的一端到另一端之间穿梭往返。
 * <p>
 * 最坏时间复杂度	O ( n^2 )
 * 最优时间复杂度	O ( n )
 * 平均时间复杂度	O ( n 2 )
 * 最坏空间复杂度	总共 O ( n )
 */

public class BubbleSortDemo {
    public static int[] bubbleSort(int[] nums) {
        //check point can optimise the Best-case complexity to O(n).
        boolean exchange;
        for (int i = nums.length - 1; i > 0; i--) {
            exchange = false;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    exchange = true;
                }
                System.out.println(Arrays.toString(nums));
            }
            if (!exchange) {
                return nums;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        bubbleSort(new int[]{7, 6, 5, 4, 3, 2, 1});
        bubbleSort(new int[]{8, 1, 2, 3, 4, 5, 6, 7});
    }
}
