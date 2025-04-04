package leetcode.question704;

/**
 * Created by zunzunwang
 * Date: 16/01/2022
 */
public class BinarySearch {
    final static int constant = 0;
    //final修饰的变量需要在constructor中进行初始化。
    final int constant2;

    public BinarySearch(int constant2) {
        this.constant2 = constant2;
    }

    /**
     * Given an array of integers nums which is sorted in ascending order,and an integer target,
     * write a function to search target in nums.
     * If target exists, then return its index. Otherwise, return -1.
     * <p>
     * You must write an algorithm with O(log n) runtime complexity.
     * 思考：
     * 将问题最后转化成极限情况：
     * [x] [x,y]
     * so while(left <= right)
     * and left = mid - 1, right = mid +1.
     * use left +((right - left) >> 1)) calculate the mid.
     */
    public int search(int[] nums, int target) {
        //Boundary condition. empty nums array
        if (nums.length < 1) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (right >= left) {
            int mid = left + ((right - left) >> 1);
            System.out.println("mid = " + mid);
            if (nums[mid] > target) {
                right = mid - 1;
                System.out.println("right = " + right);

            } else if (nums[mid] < target) {
                left = mid + 1;
                System.out.println("left = " + left);

            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * Find first equal element.
     * move right, left keep value.
     */
    public int searchFirstEqualValue(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left < nums.length && nums[left] == target)
            return left;

        return -1;
    }

    /**
     * Find last equal element.
     * move left, right keep value.
     */
    public int searchLastEqualValue(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (right >= 0 && nums[right] == target) {
            return right;
        }
        return -1;
    }

    public int searchFirstGreaterOrEqualValue(int[] nums, int target) {
        //
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + ((right - left)>>1);
            if (nums[mid] >= target ) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left < nums.length ? left : -1;
    }

    public int searchLastGreaterOrEqualValue(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while(left <= right) {
            int mid = left + ((right - left)>>1);
            if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        //[2]
        return right >= 0 ? right : -1;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 9;
        BinarySearch bs = new BinarySearch(1);
        System.out.println(bs.search(nums, target));
        /*********************************************/

        int[] nums2 = new int[]{2, 2, 2, 2, 2, 2, 2, 4, 5};
        int target2 = 2;
        System.out.println(bs.searchFirstEqualValue(nums2, target2));
        /*********************************************/

        int[] nums3 = new int[]{2, 2, 2, 2, 2, 2, 2, 4, 5};
        int target3 = 2;
        System.out.println(bs.searchLastEqualValue(nums3, target3));
        /*********************************************/

        int[] nums4 = new int[]{1, 2, 2, 2, 2, 2, 2, 4, 5};
        int target4 = 2;
        System.out.println(bs.searchFirstGreaterOrEqualValue(nums4, target4));
        /*********************************************/

        int[] nums5 = new int[]{1, 2, 2, 2, 2, 2, 2, 4, 5};
        int target5 = 3;
        System.out.println(bs.searchLastGreaterOrEqualValue(nums5, target5));
        /*********************************************/
        try{

        } catch(Exception e) {

        } finally {
            System.out.println();
        }



    }
}
