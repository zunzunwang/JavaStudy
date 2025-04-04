package wrapper;

/**
 * Created by zunzunwang
 * Date: 09/06/2022
 */
public class BooleanTest {
    public static void main(String[] args) {
        Boolean booleanTrue1 = true;// autoboxing with a constant value
        Boolean booleanTrue2 = true;
        Boolean booleanTrue3 = new Boolean(true);


        System.out.println(booleanTrue1 == booleanTrue2);
        System.out.println(booleanTrue1 == booleanTrue3);//false
    }
}
