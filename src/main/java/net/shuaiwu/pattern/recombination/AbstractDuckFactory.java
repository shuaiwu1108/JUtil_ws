package net.shuaiwu.pattern.recombination;

/**
 * 抽象鸭子工厂
 * <p>
 * 2023/11/29 22:04
 **/
public abstract class AbstractDuckFactory {

    public abstract Quackable createGreenDuck();
    public abstract Quackable createRedHeadDuck();
    public abstract Quackable createRubberDuck();
    public abstract Quackable createDuckCall();
}
