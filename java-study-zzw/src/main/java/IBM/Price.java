package IBM;

public class Price {

    //实际上这里不会产生循环， 而是直接执行了Price的构造函数 因为Price的内存空间已经分配了
    final static Price INSTANCE = new Price(2.8);
    //定义一个类变量

    static double initPrice = setInitPrice();
    //定义该Price的currentPrice实例变量


    static double setInitPrice(){
        System.out.println("set init price");
        return 20;
    }
    double currentPrice;

    public Price(double discount) {
        //根据静态变量计算实例变量
        System.out.println("price constructor " + initPrice + discount);
        currentPrice = initPrice - discount;
    }

    public static void main(String[] args) {
        //Price p = new Price(2.8);
        //通过price的INSTANCE访问currentPrice实例变量
        //System.out.println(Price.INSTANCE.currentPrice);    //  1
        //System.out.println(Price.INSTANCE.initPrice);    //  1
        //显示创建price实例
        //通过显式创建的Price实例访问currentPrice实例变量
        //System.out.println(p.currentPrice);                //   2
    }
}
