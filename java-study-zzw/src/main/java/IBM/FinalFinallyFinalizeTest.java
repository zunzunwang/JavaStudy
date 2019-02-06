package IBM;

public class FinalFinallyFinalizeTest {
    //static 后面可以跟object
    public static final Integer constant = 10;
    public static Unity u;
    public static Integer value2;

    FinalFinallyFinalizeTest(){
        value2 = 30;
    }

    //Finalize is used to perform clean up processing just before object is garbage collected.
    @Override
    public void finalize(){System.out.println("finalize called");}



    public static void main(String args[]){
        System.out.println(FinalFinallyFinalizeTest.value2);
        System.out.println(FinalFinallyFinalizeTest.u.name);
        FinalFinallyFinalizeTest.u.name = "bonjour";
        System.out.println(FinalFinallyFinalizeTest.u.name);

    }
}
