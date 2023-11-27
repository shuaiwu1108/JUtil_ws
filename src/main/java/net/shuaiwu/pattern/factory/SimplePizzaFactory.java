package net.shuaiwu.pattern.factory;

/**
 * 简单工厂模式
 *
 * @author shuaiwu
 * @date 2023-11-27 9:56
 */
public class SimplePizzaFactory extends PizzaStore{

    public Pizza createPizza(String type){
        switch (type) {
            case "cheese":
                return new CheesePizza();
            case "greek":
                return new GreekPizza();
            case "pepperoni":
                return new PepperoniPizza();
            default:
                return null;
        }
    }
}
