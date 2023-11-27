package net.shuaiwu.pattern.factory;

/**
 * 披萨店
 *
 * @author shuaiwu
 * @date 2023-11-27 10:02
 */
public abstract class PizzaStore {

    public final Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}
