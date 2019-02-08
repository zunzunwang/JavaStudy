package IBM;

public class Price {

    /**
     * ClassLoader的初始化大致分为以下步骤 （加载）->(连接[验证， 准备，解析]) -> (初始化)
     * 1.首先我们在本类中调用了main函数 或者在另外的类之中使用了Price的静态成员变量，会让ClassLoader初始化Price类对象。
     * 2.当初始化类对象， 按ClassLoader的顺序， 先加载bytecode到内存 然后在方法区开辟空间用来保存生成的 IBM.Price类对象（只生成一次）。
     *   并给所有的静态变量赋值为默认值0或者null。
     * 3.ClassLoader在完成加载， 连接之后， 需要对静态变量开始初始化我们默认的给出的等号后的值。
     * 4.运行第一行带代码 需要 新建一个类的实例赋值。此时jvm会在方法区找到已经生成的 IBM.Price类
     *  （注意此处找到的并没有完成ClassLoader最后一步初始化的IBM.Price）但是已经生成后不会进行第二次生成
     *   所以会直接使用这个静态变量初始值为0或者null的 IBM.Price来生成对象。 即直接开始初始化他的非静态成员变量。
     *   根据初始化实例的顺序 是先非静态成员变量， 非静态构造块， 最后是构造函数。
     *   所以结果是第一次先输出了 "set currency" 即成员变量的赋值， 最后才是构造函数。
     * 5.生成了Price实例后赋值给静态变量。 继续ClassLoader的初始化,对下一行代码initPrice进行赋值。
     *   所以最终生成的Price类对象的initPrice为20.（当然INSTANCE中也跟着改变）
     * 6.最终只有成员变量currentPrice是用默认值计算下来的。
     */
    
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
        System.out.println(Price.INSTANCE.initPrice);//= new Price(2.8);
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
