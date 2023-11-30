package net.shuaiwu.pattern.recombination;

/**
 * 红头鸭
 * <p>
 * 2023/11/29 21:38
 **/
public class RedHeadDuck implements Quackable{

    private Observable observable;

    public RedHeadDuck() {
        observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("Redheadduck quack");
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
        return "RedHeadDuck{" +
            "observable=" + observable +
            '}';
    }
}
