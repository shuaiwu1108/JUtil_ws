package net.shuaiwu.pattern.strategy;

/**
 * 绿头鸭
 *
 * @author shuaiwu
 * @date 2023-11-27 16:29
 */
public class MallardDuck implements Duck{

    @Override
    public void quack() {
        System.out.println("MallardDuck Quack");
    }

    @Override
    public void fly() {
        System.out.println("MallardDuck fly");
    }
}
