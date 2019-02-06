package IBM;

/**
 * 系统默认值的给予比通过等号的赋予先执行。
 */
public class Test04 {
    private static Test04 t1 = new Test04();
    private static int i1;
    private static int i2 = 2;

    public Test04()
    {

        i1++;
        i2++;
    }
    public static void main(String[] args)
    {
        //Test04 t2 = new Test04();
        Test04 t2 = null;
        System.out.println("t2.i1 = " + t2.i1);
        System.out.println("t2.i2 = " + t2.i2);
    }
}

