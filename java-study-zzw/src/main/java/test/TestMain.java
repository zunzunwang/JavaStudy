package test;


import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestMain {


    public static void  main(String args[]){
        int[] a = {1,2,3};
        int[] b = {1,2};
        test(a,b);

        int a1 = 8;
        int a2 = 9;
        System.out.println(a1<<2);

        //if we don't add break, the code will run until the last case without check the condition.
        System.out.print(a1+a2);
        switch(a1){
            case 17:
                System.out.println("value is 17");
                break;
            case 18:
                System.out.println("value is 18");
                break;
            case 19:
                System.out.println("value is 19");
                break;
            case 20:
                System.out.println("value is 20");
                break;
            default:
                System.out.println("value is default");
                break;
        }


        first:
        for(int i=0; i<10; i++){
            second:
            for(int j=0;j<10;j++){
                System.out.println("i: " + i + " j: " + j);
                break first;
            }
        }





    }

    public static void test(int[] a , int[] b){
        System.out.println(Character.getNumericValue('a'));
        System.out.println(Character.getNumericValue('b'));
        System.out.println('a' & 'b');
    }



    /*
    public static void  main(String args[]){

        int cap = 19;
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        System.out.println((n < 0) ? 1 : (n >= 30<<1) ? (30<<1) : n + 1);
        Map<String, String> map2 = new Hashtable<>();
        Set s = map2.keySet();



    }
    */
}

/*
        public static boolean exists(int[] arr, int key) {
            int min = 0, max = arr.length - 1, mid;

            while (min <= max) {
                mid = (min + max) >> 1;
                if (key > arr[mid])
                    min = mid + 1;
                else if (key < arr[mid])
                    max = mid - 1;
                else
                    return true;
            }
            return false;
        }

        public static boolean exists2(int[] arr, int key) {
            return Arrays.binarySearch(arr, key) >= 0;
        }

        void print(Reader reader) throws IOException {
            int code = 0;
            try {



                System.out.println(reader.toString());




            reader.close();
        }



        public StringBuffer res;

        public TextInput() {
            res = new StringBuffer();
        }

        public void add(char c) {
            res.append(c);
        }

        public String getValue() {
            return res.toString();
        }

    }

    public static class NumericInput extends TextInput {
        public NumericInput() {
            this.res = new StringBuffer();
        }

        @Override
        public void add(char c) {
            if (Character.isDigit(c)) {
                this.res.append(c);
            }
        }

    }


    public static boolean isPalindrome(String word) {
        word = word.toLowerCase();
        char[] cl = word.toCharArray();
        for (int i = 0; i < cl.length / 2; i++) {
            if (!(cl[i] == cl[cl.length - i - 1])) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

    }


}
*/
