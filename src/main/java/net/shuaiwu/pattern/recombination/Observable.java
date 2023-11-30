package net.shuaiwu.pattern.recombination;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 观察者
 *
 * @author shuaiwu
 * @date 2023-11-30 8:49
 */
public class Observable implements QuackObservable{
    private ArrayList observers = new ArrayList();
    private QuackObservable duck;

    public Observable(QuackObservable duck) {
        this.duck = duck;
    }

    @Override
    public void registerObservable(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObserver() {
        Iterator iterator = observers.iterator();
        while (iterator.hasNext()){
            Observer o = (Observer) iterator.next();
            o.update(duck);
        }
    }
}
