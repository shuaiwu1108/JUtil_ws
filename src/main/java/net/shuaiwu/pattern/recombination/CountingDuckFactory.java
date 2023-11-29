package net.shuaiwu.pattern.recombination;

/**
 * 装饰者鸭子工厂
 * <p>
 * 2023/11/29 22:07
 **/
public class CountingDuckFactory extends AbstractDuckFactory{
    @Override
    public Quackable createGreenDuck() {
        return new QuackCounter(new GreenDuck());
    }

    @Override
    public Quackable createRedHeadDuck() {
        return new QuackCounter(new RedHeadDuck());
    }

    @Override
    public Quackable createRubberDuck() {
        return new QuackCounter(new RubberDuck());
    }

    @Override
    public Quackable createDuckCall() {
        return new QuackCounter(new DuckCall());
    }
}
