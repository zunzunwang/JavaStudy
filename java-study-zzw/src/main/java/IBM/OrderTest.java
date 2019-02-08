package IBM;

public class OrderTest {
}

class Door{
    Door(int marker){
        System.out.println("Door("+marker+")");
    }
}

class House{
    Door d1=new Door(1);  //定义发生在构造器调用之前
    House(){
        System.out.println("House()");
        d3=new Door(8);   //对d3的重新定义
    }
    Door d2=new Door(2);  //定义发生在构造器调用之后
    void f(){
        System.out.println("f()");
    }
    Door d3=new Door(3);  //定义发生在最后
}

class Order {
    public static void main(String args[])
    {
        House h=new House();
        h.f();
    }
}