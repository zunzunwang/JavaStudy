package heritage.father;

public class FatherClass {
    public String name;
    protected int age;
    String work;
    private String money;

    protected FatherClass() {
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
}
