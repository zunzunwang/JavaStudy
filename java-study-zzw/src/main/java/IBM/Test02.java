package IBM;

public class Test02 {

    private Test01 t1 = new Test01(1);
    private int n = 10;

    public Test02(){
        System.out.println("Test02 of constructor : " + n);
    }
    private Test01 t2 = new Test01(2);

    public static void main(String[] args){
        Test02 test = new Test02();
    }


}
