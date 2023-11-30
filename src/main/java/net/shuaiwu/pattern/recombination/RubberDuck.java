package net.shuaiwu.pattern.recombination;

/**
 * 橡皮鸭
 * <p>
 * 2023/11/29 21:41
 **/
public class RubberDuck implements Quackable {

    private Observable observable;

    public RubberDuck() {
        observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("Rubberduck quack");
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
        return "RubberDuck{" +
            "observable=" + observable +
            '}';
    }
}
