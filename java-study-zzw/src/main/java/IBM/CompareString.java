package IBM;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//手写冒泡排序
//https://www.bilibili.com/video/av39519566?from=search&seid=18440304922662107094
public class CompareString {
    public static boolean checkString(String s1, String s2) {
        //check null
        if (s1 == null || s2 == null) {
            return false;
        }

        //check length
        if (s1.length() != s2.length()) {
            return false;
        }

        s1 = sort(s1);
        s2 = sort(s2);
        return s1.equals(s2);
    }

    public static String sort(String s1) {
        char[] arrayCh = s1.toCharArray();
        //Arrays.sort(arrayCh);
        quickSortChar(arrayCh, 0, arrayCh.length-1);
        String sortedStr = new String(arrayCh);
        return sortedStr;
    }

    public static void quickSortChar(char[] array, int left, int right) {
        //condition
        if (array.length < 0 || left > right) {
            return;
        }
        //get the value of left one.
        char base = array[left];
        //get left boundary
        int leftIndex = left;
        //get right boundary
        int rightIndex = right;

        while (leftIndex != rightIndex) {
            //compare from right to left. If value > base,
            //continue move until find the first smaller value.
            while (array[rightIndex] >= base && rightIndex > leftIndex) {
                rightIndex--;
            }

            //compare from left to right. If value < base,
            //continue move until find the first bigger value.
            while (array[leftIndex] <= base && rightIndex > leftIndex) {
                leftIndex++;
            }

            //when they find the value. exchange the two value.
            char tmp = array[rightIndex];
            array[rightIndex] = array[leftIndex];
            array[leftIndex] = tmp;
        }

        array[left] = array[leftIndex];
        array[leftIndex] = base;

        //continue in two sub array.
        quickSortChar(array, left, leftIndex - 1);
        quickSortChar(array, leftIndex + 1, right);
    }

    public static boolean checkStringHash(String s1, String s2) {
        //check null
        if (s1 == null || s2 == null) {
            return false;
        }

        //check length
        if (s1.length() != s2.length()) {
            return false;
        }
        //add to map
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < s1.length(); i++) {
            if (map.containsKey(s1.charAt(i))) {
                map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
            } else {
                map.put(s1.charAt(i), 1);
            }
        }

        //delete from map
        for (int j = 0; j < s2.length(); j++) {
            if (!map.containsKey(s2.charAt(j))) {
                return false;
            } else {
                if (map.get(s2.charAt(j)) > 1) {
                    map.put(s2.charAt(j), map.get(s2.charAt(j)) - 1);
                } else {
                    map.remove(s2.charAt(j));
                }
            }
        }
        return map.size() == 0;
    }

    public static void main(String args[]) {
        System.out.println(checkString("abdce", "ecdba"));
        System.out.println(checkString("abdce", null));
        System.out.println(checkString("abdce", "ecd"));
        char[] test = {'a','z','c','y','w','b'};
        quickSortChar(test, 0, test.length-1);
        for (char t : test){
            System.out.print(t);
        }

    }
}
