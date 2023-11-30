package net.shuaiwu.pattern.recombination;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 群鸭
 * 使用组合模式：像单个对象一样对待集合对象
 * 使用迭代器模式
 * 2023/11/29 22:14
 **/
public class Flock implements Quackable{
    private ArrayList quackers = new ArrayList();
    public void add(Quackable duck){
        quackers.add(duck);
    }
    @Override
    public void quack() {
        Iterator iterator = quackers.iterator();
        while (iterator.hasNext()){
            Quackable next = (Quackable) iterator.next();
            next.quack();
        }
    }

    @Override
    public void registerObservable(Observer observer) {
        Iterator iterator = quackers.iterator();
        while (iterator.hasNext()){
            Quackable duck = (Quackable) iterator.next();
            duck.registerObservable(observer);
        }
    }

    @Override
    public void notifyObserver() {
//        observable.notifyObserver();
    }
}
