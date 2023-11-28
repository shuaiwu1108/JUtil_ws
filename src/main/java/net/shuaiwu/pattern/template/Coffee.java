package net.shuaiwu.pattern.template;

/**
 * 咖啡
 *
 * @author shuaiwu
 * @date 2023-11-28 11:06
 */
public class Coffee extends CaffeineBeverage{

    @Override
    public void brew() {
        System.out.println("Coffee brew");
    }

    @Override
    public void addCondiments() {
        System.out.println("Coffee add condiments");
    }
}
