package algorithme;

/**
 * 归并排序的复杂度为 O(nlogn)
 */
public class MergeSort {
    public static void mergeSort(int[] arr) {
        //建立一个辅助存储的数组
        int[] orderedArr = new int[arr.length];

        //i的循环过程是2, 4, 6, 8. 一直到length的2倍
        for (int i = 2; i < arr.length * 2; i *= 2) {

            //以i为2举例
            for (int j = 0; j < (arr.length + i - 1) / i; j++) {
                int left = i * j;
                int mid = left + i / 2 >= arr.length ? (arr.length - 1) : (left + i / 2);
                int right = i * (j + 1) - 1 >= arr.length ? (arr.length - 1) : (i * (j + 1) - 1);
                int start = left, l = left, m = mid;
                while (l < mid && m <= right) {
                    if (arr[l] < arr[m]) {
                        orderedArr[start++] = arr[l++];
                    } else {
                        orderedArr[start++] = arr[m++];
                    }
                }
                while (l < mid)
                    orderedArr[start++] = arr[l++];
                while (m <= right)
                    orderedArr[start++] = arr[m++];
                System.arraycopy(orderedArr, left, arr, left, right - left + 1);
            }
        }
    }


    public static void mergeSortRecusive(int[] arrays){


    }

    public static void merge(int[] arrays, int left, int mid, int right){
        int leftPoint;

    }


    public static void main(String[] args) {
        int[] arrays = new int[]{1,9,2,8,3,7,4,6,5};
        mergeSort(arrays);

        for (int a : arrays){
            System.out.print(a);
        }
    }
}

