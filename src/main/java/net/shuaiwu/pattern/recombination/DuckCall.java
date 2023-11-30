package net.shuaiwu.pattern.recombination;

/**
 * 鸭鸣器
 * <p>
 * 2023/11/29 21:40
 **/
public class DuckCall implements Quackable{

    private Observable observable;

    public DuckCall() {
        observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("Duckcall quack");
        notifyObserver();
    }

    @Override
    public void registerObservable(Observer observer) {
        observable.registerObservable(observer);
    }

    @Override
    public void notifyObserver() {
        observable.notifyObserver();
    }

    @Override
    public String toString() {
        return "DuckCall{" +
            "observable=" + observable +
            '}';
    }
}
