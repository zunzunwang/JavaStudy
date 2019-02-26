package IBM;

public class ClassLoaderArray {
    public static void main(String[] args) {
        A[] x= new A[4];
    }
}

class A {
    static {
        System.out.println("animal static init!");
    }
}

