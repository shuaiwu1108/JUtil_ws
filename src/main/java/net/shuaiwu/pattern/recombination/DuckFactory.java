package net.shuaiwu.pattern.recombination;

/**
 * 鸭子创建工厂
 * <p>
 * 2023/11/29 22:06
 **/
public class DuckFactory extends AbstractDuckFactory{
    @Override
    public Quackable createGreenDuck() {
        return new GreenDuck();
    }

    @Override
    public Quackable createRedHeadDuck() {
        return new RedHeadDuck();
    }

    @Override
    public Quackable createRubberDuck() {
        return new RubberDuck();
    }

    @Override
    public Quackable createDuckCall() {
        return new DuckCall();
    }
}
