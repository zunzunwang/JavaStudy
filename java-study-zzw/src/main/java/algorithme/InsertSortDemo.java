package algorithme;

public class InsertSortDemo {
    public static int[] insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i ++ ) {
            int key = nums[i];
            int j = i - 1;

            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
        return nums;
    }

    public static void toString(int[] nums){
        for (int i = 0; i< nums.length; i++){
            System.out.print(nums[i]);
        }
    }

    public static void main(String[] args) {
        toString(insertSort(new int[]{7, 6, 5, 4, 3, 2, 1}) );
        System.out.println();
        toString(insertSort(new int[]{8, 1, 3, 2, 4, 9, 6, 7}));
    }
}
