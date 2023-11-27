package net.shuaiwu.pattern.factory;

/**
 * 披萨测试类
 *
 * @author shuaiwu
 * @date 2023-11-27 10:51
 */
public class PizzaTest {

    public static void main(String[] args) {
        PizzaStore p1 = new NYPizzaFactory();
        PizzaStore p2 = new SimplePizzaFactory();

        Pizza pp1 = p1.orderPizza("cheese");
        Pizza pp2 = p2.orderPizza("greek");

        System.out.println(pp1);
        System.out.println(pp2);
    }
}
