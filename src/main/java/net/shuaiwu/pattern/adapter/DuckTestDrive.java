package net.shuaiwu.pattern.adapter;

import net.shuaiwu.pattern.strategy.Duck;
import net.shuaiwu.pattern.strategy.MallardDuck;

/**
 * 鸭子测试
 *
 * @author shuaiwu
 * @date 2023-11-27 16:35
 */
public class DuckTestDrive {

    public static void main(String[] args) {
        MallardDuck md = new MallardDuck();

        WildTurkey wt = new WildTurkey();
        Duck duck = new TurkeyAdapter(wt);

        System.out.println("The Turkey says...");
        wt.gobble();
        wt.fly();

        System.out.println("\nThe Duck says...");
        testDuck(md);

        System.out.println("\nThe TurkeyAdapter says...");
        testDuck(duck);
    }

    public static void testDuck(Duck duck){
        duck.quack();
        duck.fly();
    }
}
