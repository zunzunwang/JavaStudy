package heritage.father;

public class FatherClass {
    public static String valueStaticNotMentioned = "I'm static not mentioned father";
    public static String valueStaticMentioned = "I'm static mentioned father";
    public String valueNotStatic = "I'm not static father";
    public String name;
    protected int age;
    String work;
    private String money;

    public FatherClass() {
        name = "Father";
        age = 50;
        work = "doctor";
        money = "EUR";
    }

    public void relax(){
        System.out.println("I'm father, I read book for relaxing.");
    }

    public void cook(){
        System.out.println("I'm father, I cook for my family.");
    }

    public static void wc() { System.out.println("I'm father, I'm static method");}
}
