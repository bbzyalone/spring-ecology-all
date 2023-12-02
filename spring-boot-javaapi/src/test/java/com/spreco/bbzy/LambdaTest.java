package com.spreco.bbzy;

import junit.framework.TestCase;

import java.util.Comparator;
import java.util.function.Consumer;


/**
 * Lambda 测试类
 */
public class LambdaTest extends TestCase {


    /**
     * 基本
     */
    public void test1() {

        /**
         * 普通写法
         * */
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " is running");
            }
        };
        r1.run();
        System.out.println("******************************");
        Runnable r2 = () -> {
            System.out.println(Thread.currentThread().getName() + " is running");
        };
        r2.run();

    }

    /**
     * 简化和方法引用
     */
    public void test2() {
        //Comparator 比较器
        Comparator<Integer> con1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare1 = con1.compare(16, 13); // -1: o1 < o1 | 0: o1==o1 |1: o1 > o2
        System.out.println(compare1);

        System.out.println("******************************");

        //lambda写法
        Comparator<Integer> con2 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(con2.compare(1, 2));

        System.out.println("******************************");

        //方法引用写法
        Comparator<Integer> con3 = Integer::compareTo;
        System.out.println(con3.compare(1, 1));

        //附加写法
        Comparator<Integer> con4 = Comparator.comparingInt(o -> o);
        System.out.println("******************************");
        System.out.println(con4.compare(3, 2));
    }

    /**
     * 功能接口
     * Consumer 的功能接口是一个接受单一参数并且不返回任何结果的操作。 Consumer 的功能方法是
     * andThen(Consumer<T t>)
     * accept(T t)
     */
    public void test3() {
        Consumer<String> con1 = (a) -> System.out.println("我就想不通了=====" + a);
        Consumer<String> con2 = a -> System.out.println("你为啥想不通=====" + a);
        con1.andThen(con2).accept("王轲强");

    }

    /**
     * 本质
     * Lambda表达式是接口实现类的对象
     * lambda是一个匿名函数
     * lambda 基于函数式接口
     *
     * */

}
