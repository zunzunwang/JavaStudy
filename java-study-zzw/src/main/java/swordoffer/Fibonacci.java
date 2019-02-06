package swordoffer;

public class Fibonacci {

    public int Fibonacci(int n) {
        if (n < 1){
            return 0;
        } else if (n == 1){
            return 1;
        } else {
            int[] resArray =  new int[n+1];
            resArray[0] = 0;
            resArray[1] = 1;
            for (int i = 2; i <= n; i++){
                resArray[i] = resArray[i-1] + resArray[i-2];
            }
            return resArray[n];
        }
    }

    public int FibonacciNotSave(int n) {
        if (n < 1){
            return 0;
        } else if (n == 1){
            return 1;
        } else {
            int pStart = 0;
            int pEnd = 1;

            for (int i = 2; i <= n; i++){
                pEnd += pStart;
                pStart = pEnd - pStart;
            }
            return pEnd;
        }
    }
}
