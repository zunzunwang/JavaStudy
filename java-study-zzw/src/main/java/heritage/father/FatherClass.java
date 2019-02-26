package heritage.father;

public class FatherClass {
    public final static String valueFinalStaticFather = "I'm final static father element";
    public static String valueStaticNotMentioned = "I'm static not mentioned father";
    public static String valueStaticMentioned = "I'm static mentioned father";
    public final String valueFinal;

    static {
        System.out.println("father static code area.");
    }

    public String valueNotStatic = setValueNotStatic();

    public String setValueNotStatic(){
        System.out.println("set value not static");
        return  "I'm not static father";
    }

    {
        System.out.println("init value Final Father");
        valueFinal = "I'm final father";
    }

    public String name;
    public int age;
    String work;
    private String money;

    public FatherClass() {
        name = "Father";
        age = 50;
        work = "doctor";
        money = "EUR";
    }

    public void relax() {
        System.out.println("I'm father, I read book for relaxing.");
    }

    public void cook() {
        System.out.println("I'm father, I cook for my family.");
    }

    public static void wc() {
        System.out.println("I'm father, I'm static method");
    }

    public final  void sleep() {
        System.out.println("I'm father, I'm final static method ");
    }
}
