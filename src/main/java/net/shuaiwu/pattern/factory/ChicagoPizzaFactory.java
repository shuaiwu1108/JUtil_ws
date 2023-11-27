package net.shuaiwu.pattern.factory;

/**
 * 芝加哥披萨店
 *
 * @author shuaiwu
 * @date 2023-11-27 10:34
 */
public class ChicagoPizzaFactory extends PizzaStore{

    public Pizza createPizza (String type){
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
