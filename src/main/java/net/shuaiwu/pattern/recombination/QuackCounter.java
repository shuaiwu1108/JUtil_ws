package net.shuaiwu.pattern.recombination;

import net.shuaiwu.pattern.strategy.Duck;

/**
 * 鸭子装饰者
 * <p>
 * 2023/11/29 21:56
 **/
public class QuackCounter implements Quackable{
    private Quackable duck;
    private static int numberOfQuacks;

    public QuackCounter(Quackable duck) {
        this.duck = duck;
    }

    @Override
    public void quack() {
        duck.quack();
        numberOfQuacks++;
    }

    public static int getNumberOfQuacks(){
        return numberOfQuacks;
    }

    @Override
    public void registerObservable(Observer observer) {
        duck.registerObservable(observer);
    }

    @Override
    public void notifyObserver() {
        duck.notifyObserver();
    }
}
