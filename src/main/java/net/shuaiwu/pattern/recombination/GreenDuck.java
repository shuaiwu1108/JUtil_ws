package net.shuaiwu.pattern.recombination;

/**
 * 绿头鸭
 * <p>
 * 2023/11/29 21:37
 **/
public class GreenDuck implements Quackable{

    private Observable observable;

    public GreenDuck() {
        observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("Greenduck quack");
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
        return "GreenDuck{" +
            "observable=" + observable +
            '}';
    }
}
