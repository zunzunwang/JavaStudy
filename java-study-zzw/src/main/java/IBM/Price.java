package IBM;

public class Price {

    //实际上这里不会产生循环， 而是直接执行了Price的构造函数 因为Price的内存空间已经分配了
    //定义一个类变量
    final static Price INSTANCE = new Price(2.8);
    static double initPrice = setInitPrice();

    //改变了类对象的初始化中 最后一步赋值的顺序。
    // /final static Price INSTANCE = new Price(2.8);

    //实例变量会产生递归对于price。
    // Price instance = new Price(2.8);

    String currency = getCurrency();

    private String getCurrency(){
        System.out.println("set currency");
        return "Euro";
    }


    static double setInitPrice(){
        System.out.println("set init price");
        return 20;
    }
    double currentPrice;

    public Price(double discount) {
        //根据静态变量计算实例变量
        System.out.println("price constructor " + initPrice + " " + discount);
        currentPrice = initPrice - discount;
    }


    public static void main(String[] args) {
        Price p ;//= new Price(2.8);
        //System.out.println(Price.INSTANCE.initPrice);
        //通过price的INSTANCE访问currentPrice实例变量
        //System.out.println(Price.INSTANCE.currentPrice);    //  1
        //System.out.println(Price.INSTANCE.initPrice);    //  1
        //显示创建price实例
        //通过显式创建的Price实例访问currentPrice实例变量
        //System.out.println(p.currentPrice);                //   2
    }

}

/*
class Main{
    public static void main(String args[]){
        System.out.println(Price.INSTANCE);

    }
}
*/
