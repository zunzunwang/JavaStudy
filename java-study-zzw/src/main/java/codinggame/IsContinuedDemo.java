package codinggame;

import java.util.ArrayList;
import java.util.Arrays;

public class IsContinuedDemo {
    public boolean IsContinuous(ArrayList<Integer> numbers) {
        int indexMax = 0;
        int indexMin = 13;
        if (numbers != null && numbers.size() > 0){
            int[] intArray = new int[14];
            for (int num : numbers){
                if (num > indexMax){
                    indexMax = num;
                }
                if (num > 0 && num < indexMin) {
                    indexMin = num;
                }//if get two same number, return false directly
                if(num == 0 || intArray[num] == 0) {
                    intArray[num]++;
                } else {
                    return false;
                }
            }
            if (numbers.size() - intArray[0] <= 1){
                return true;
            } else {
                if (indexMax - indexMin + 1 > numbers.size()){
                    return false;
                } else {
                 return true;
                }
            }
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        IsContinuedDemo i = new IsContinuedDemo();
        Integer[] array = {new Integer(0),new Integer(2),new Integer(3),new Integer(0), new Integer(0)};
        ArrayList<Integer> l1 = new ArrayList<Integer>(Arrays.asList(array));

        System.out.println("l1:" + i.IsContinuous(l1));



    }
}
