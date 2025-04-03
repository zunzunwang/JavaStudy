package codinggame;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayContains {

    public static boolean exist(int[] ints, int k) {
        //use directly API
        //Arrays.binarySearch(ints, k) != -1;
        int left = 0;
        int right = ints.length-1;

        while(left < right) {
            int mid = ((right - left) >>> 1) + left;
            if(ints[mid] == k) {
                return true;
            } else if (ints[mid] > k) {
                right = mid - 1;
                System.out.println("left:" + left + " right:" + right);
            } else {
                left = mid + 1;
                System.out.println("left:" + left + " right:" + right);
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] testInts = new int[20];

        testInts = Arrays.stream(testInts).map(x -> ThreadLocalRandom.current().nextInt(100)).sorted().toArray();
        System.out.println(Arrays.toString(testInts));
        System.out.println(ArrayContains.exist(testInts, 18));
    }
}
