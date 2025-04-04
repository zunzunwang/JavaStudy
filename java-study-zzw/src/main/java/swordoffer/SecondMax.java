package swordoffer;

/**
 * Created by zunzunwang
 * Date: 22/06/2022
 */
public class SecondMax {

    public static Integer searchSecondMax(Integer[] array){
        //null ou one element
        if(array == null || array.length < 2){
            return null;
        }

        //pointer of the array.
        Integer max = 0;
        Integer secondMax = 0;

        for (int i = 0; i < array.length; i++){
            if(array[i] > array[max]) {
                secondMax = max;
                max = i;
            } else if (array[i] < array[max] && array[i] > array[secondMax]) {
                secondMax = i;
            }
        }

        if (max != secondMax) {
            return array[secondMax];
        } else {
            System.out.println("Don't find the second max value.");
            return null;
        }
    }

    public static void main(String[] args) {
        Integer[] iarray = new Integer[]{-1,1,2,3,9};
        System.out.println(SecondMax.searchSecondMax(iarray));

        iarray = new Integer[]{1,1,1,2,2,2,3,3,3};
        System.out.println(SecondMax.searchSecondMax(iarray));

        iarray = new Integer[]{-1,1,-2,2,-4,4,-3,3};
        System.out.println(SecondMax.searchSecondMax(iarray));
    }
}
