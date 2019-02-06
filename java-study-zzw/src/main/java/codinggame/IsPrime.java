package codinggame;

public class IsPrime {
    public static boolean isPrime(int n){
        if((n > 2 && n % 2 == 0) || n == 1) {
            return false;
        }

        for (int i = 3; i <= (int)Math.sqrt(n); i += 2) {

            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        System.out.println(IsPrime.isPrime(5));
        System.out.println(IsPrime.isPrime(15));
        System.out.println(IsPrime.isPrime(32));
        System.out.println(IsPrime.isPrime(67));

    }
}
