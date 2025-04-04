package IBM;

/**
 * Created by zunzunwang
 * Date: 2019-03-04
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.zhihu.com/question/20400700/answer/117464182
 * 首先我们建立两个类Fruit和Apple。
 * 苹果是水果的子类。
 */

class Fruit {
    public void sayHello() {
        System.out.println("I'm Fruit.");
    }
}

class Apple extends Fruit {
    @Override
    public void sayHello() {
        System.out.println("I'm Apple.");
    }
}

class Peer extends Fruit {
    @Override
    public void sayHello() {
        System.out.println("I'm Peer.");
    }
}

/**
 * 建立一个泛型类plate，用来保存两种水果。
 * 私有成员变量：泛型变量
 * 公有初始化函数：非空传递泛型变量
 * 公有成员方法：
 * 放(set)水果。
 * 取(get)水果。
 */
class Plate<T> {
    private T content;

    public Plate(T t) {
        content = t;
    }

    public Plate() {
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public <E extends Fruit> void showPlate1(List<E> l) {
        for (E e : l) {
            //这里可以显式的声明
            e.sayHello();
        }
    }

    public void showPlate2(List<? extends Fruit> l) {
        for (int i = 0; i < l.size(); i++) {
            l.get(i).sayHello();
        }
    }


}

public class Generics {
    //使用反射的方法创建实例
    public static <T> T createInstance(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }

    public static void main(String[] args) {
        try {
            Fruit fruit = createInstance(Fruit.class);
            fruit.sayHello();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        //会出现错误， 因为容器里装的东西之间有继承关系，但容器之间是没有继承关系的。
        //Plate<Fruit> p = new Plate<Apple>(new Apple());

        List<Apple> listApple = Arrays.asList(new Apple());
        List<Peer> listPeer = Arrays.asList(new Peer());
        List<Fruit> listFruit = Arrays.asList(new Apple(), new Peer());

        Plate<Fruit> plate = new Plate<>();
        plate.showPlate1(listApple);
        plate.showPlate1(listPeer);
        plate.showPlate1(listFruit);

        //？有界通配符一般是在使用的时候使用。 而在定义的时候使用类型参数T直接定义。
        Plate<? extends Fruit> p = new Plate<Apple>(new Apple());
        Plate<? extends Fruit> p3 = new Plate<Fruit>(new Apple());
        //object不是Fruit的子类所以报错
        //Plate<? extends Fruit> p4 = new Plate<Object>(new Apple());



        /**
         * <? extends Fruit> 会使得往盘子里放的东西的函数set都失效 而取东西的函数get还有效
         */
        //p.setContent(new Fruit());
        //p.setContent(new Apple());


        /**
         * 取出来的东西只能放在Fruit的基类之中。
         */
        Fruit f = p.getContent();
        Object o = p.getContent();
        //Apple a = p.getContent();

        /**
         * 原因是编译器只知道容器内是Fruit或者它的派生类，但具体是什么类型不知道。可能是Fruit？可能是Apple？
         * 也可能是Banana，RedApple，GreenApple？
         * 编译器在看到后面用Plate<Apple>赋值以后，盘子里没有被标上有“苹果”。
         * 而是标上一个占位符：CAP#1，来表示捕获一个Fruit或Fruit的子类，具体是什么类不知道，代号CAP#1。
         * 然后无论是想往里插入Apple或者Meat或者Fruit编译器都不知道能不能和这个CAP#1匹配，所以就都不允许。
         * Plate<?>单纯的就表示：盘子里放了一个东西，是什么我不知道。
         */

        /**
         * 下界<? super T>不影响往里存，但往外取只能放在Object对象里
         * super限制的是 后面创建的容器声明里面的Fruit 而通过Fruit来限制 new Apple()
         */
        Plate<? super Fruit> p2 = new Plate<Fruit>(new Apple());
        // Apple不是Fruit的父类所以报错
        //Plate<? super Fruit> p5 = new Plate<Apple>(new Apple());

        //p2.setContent(new Object());
        p2.setContent(new Fruit());
        p2.setContent(new Apple());

        //Apple apple = p2.getContent();
        //虽然这里强制转型成了fruit 但是成员函数用的还是apple 因为保存进去最后是一个Apple类型的函数。
        Fruit fruit = (Fruit) p2.getContent();
        fruit.sayHello();
        Object object = p2.getContent();

        //总结为向下限制只能取，取出来的是指定类的基类
        //向上限制只能存只能存 存入给定类的子类



        //最后看一下什么是PECS（Producer Extends Consumer Super）原则，已经很好理解了：
        //频繁往外读取内容的，适合用上界Extends。经常往里插入的，适合用下界Super。
    }
}
