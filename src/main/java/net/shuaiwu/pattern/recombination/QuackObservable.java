package net.shuaiwu.pattern.recombination;

/**
 * 被观察者接口
 *
 * @author shuaiwu
 * @date 2023-11-30 8:45
 */
public interface QuackObservable {

    void registerObservable(Observer observer);
    void notifyObserver();
}
