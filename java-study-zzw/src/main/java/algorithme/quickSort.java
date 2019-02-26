package algorithme;

//快速排序的平均复杂度为O(n ㏒n)
//快排会把数组中的一个数当作基准数， 一般会把数组中最左边的数当作基准数。或者参照物。
//会从两边进行检索
//从右边检索比基准数小的
//从左边检索比基准数大的
//如果检索到了就停下。
//然后交换这两个元素
//然后继续检索
//i和j一旦相遇则停止检索， 把基准数和相遇位置的元素进行交换
//基准数左边都比他小， 基准数右边都比他大
//第二轮和第一轮一样。 先排基准数左边 再排基准数右边。

public class quickSort {
    public static void quickSort(int[] arr){
        qsort(arr, 0, arr.length-1);
    }
    private static void qsort(int[] arr, int low, int high){
        if (low < high){
            int pivot=partition(arr, low, high);        //将数组分为两部分
            qsort(arr, low, pivot-1);                   //递归排序左子数组
            qsort(arr, pivot+1, high);                  //递归排序右子数组
        }
    }
    private static int partition(int[] arr, int low, int high){
        int pivot = arr[low];     //枢轴记录
        while (low<high){
            while (low<high && arr[high]>=pivot) --high;
            arr[low]=arr[high];             //交换比枢轴小的记录到左端
            while (low<high && arr[low]<=pivot) ++low;
            arr[high] = arr[low];           //交换比枢轴小的记录到右端
        }
        //扫描完成，枢轴到位
        arr[low] = pivot;
        //返回的是枢轴的位置
        return low;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,9,2,8,3,7,4,6,5};
        quickSort(test);

        for (int i = 0; i < test.length; i++)
        System.out.println(test[i]);
    }
}
