package net.shuaiwu.pattern.template;

/**
 * 咖啡因饮料
 *
 * @author shuaiwu
 * @date 2023-11-28 11:13
 */
public abstract class CaffeineBeverage {

    public final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments())
            addCondiments();
    }

    public abstract void brew();

    public abstract void addCondiments();

    public void boilWater(){
        System.out.println("CaffeineBeverage boil water");
    }

    public void pourInCup(){
        System.out.println("CaffeineBeverage pour in cup");
    }

    // 钩子，由子类去判定是否需要添加调料，默认添加
    public boolean customerWantsCondiments(){
        return true;
    }
}
