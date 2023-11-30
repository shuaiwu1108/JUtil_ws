package net.shuaiwu.pattern.recombination;

/**
 * 呱呱叫观察者
 *
 * @author shuaiwu
 * @date 2023-11-30 9:04
 */
public class Quackologist implements Observer{

    @Override
    public void update(QuackObservable duck) {
        System.out.println("Quackologist: " + duck + " just quacked.");
    }
}
