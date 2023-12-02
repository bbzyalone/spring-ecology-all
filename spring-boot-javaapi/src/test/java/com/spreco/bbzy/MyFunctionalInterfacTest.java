package com.spreco.bbzy;

import com.spreco.bbzy.function.MyFunctionalInterfac;
import junit.framework.TestCase;

public class MyFunctionalInterfacTest extends TestCase {


    /**
     * 函数式接口
     * 只有一个抽象方法 可以有多个默认方法
     * 只有函数式接口提供实现类的对象时，才可以使用Lambda表达式
     *
     * @FunctionalInterface //函数式接口的声明和校验
     */
    public void test() {
        MyFunctionalInterfac myfunction = () -> System.out.println("哈哈哈");
        myfunction.method();
    }

    /**
     * 常用的函数式接口
     * 定义在 java.base 模块 java.util.function中
     * Consumer<T>  消费型  为类型为T的对象应用操作 包含方法 void accept(T t); Consumer<T> andThen(Consumer<? super T> after)
     * Supplier  供给性 无参 返回类型为T的对象 包含方法 T get();
     * Function<T, R> 函数型  为类型为T的对象应用操作 并返回结果 并返回结果
     * R apply(T t);
     * compose(Function<? super V, ? extends T> before)
     * andThen(Function<? super R, ? extends V> after)
     * identity()
     *
     * Predicate<T> 定义类型为T的对象是否满足某条件约束 返回boolean 值
     * test(T t)
     * and(Predicate<? super T> other)
     * negate()
     * or(Predicate<? super T> other)
     * isEqual(Object targetRef)
     * not(Predicate<? super T> target)
     * */

    /**
     * 消费型扩展
     *  BiConsumer<T, U>  接受两个对象完成功能
     *  DoubleConsumer    接受一个double值
     *  IntConsumer       接受一个int值
     *  ObjDoubleConsumer<T>   接受一个对象和一个double值
     *  等.................
     * */

    /**
     * 供给型
     * BooleanSupplier  返回一个boolean值
     * 等...............
     * */

    /**
     * 函数型
     * UnaryOperator<T>  接受一个T类型对象 返回一个T类型对象
     * 等...............
     * */
}
