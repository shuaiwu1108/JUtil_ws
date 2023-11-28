package net.shuaiwu.pattern.template;

/**
 * 茶
 *
 * @author shuaiwu
 * @date 2023-11-28 11:10
 */
public class Tea extends CaffeineBeverage{


    @Override
    public void brew() {
        System.out.println("Tea brew");
    }

    @Override
    public void addCondiments() {
        System.out.println("Tea add condiments");
    }

    @Override
    public boolean customerWantsCondiments() {
        return false;
    }
}
