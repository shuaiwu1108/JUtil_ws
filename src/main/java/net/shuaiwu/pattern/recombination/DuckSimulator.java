package net.shuaiwu.pattern.recombination;

/**
 * 鸭子模拟器
 * <p>
 * 2023/11/29 21:43
 **/
public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator duckSimulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();
        duckSimulator.simulate(duckFactory);
    }

    private void simulate(AbstractDuckFactory duckFactory) {
        Quackable redHeadDuck = duckFactory.createRedHeadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();

        //将一只鹅包装进鸭子中
        Quackable goose = new QuackCounter(new GooseAdapter(new Goose()));

        System.out.println("\nDuck Simulator: with Abstract Factory");

        Flock flockOfDucks = new Flock();
        flockOfDucks.add(redHeadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(goose);

        Quackable greenDuck1 = duckFactory.createGreenDuck();
        Quackable greenDuck2 = duckFactory.createGreenDuck();
        Quackable greenDuck3 = duckFactory.createGreenDuck();
        Quackable greenDuck4 = duckFactory.createGreenDuck();
        Flock flockOfGreenDucks = new Flock();
        flockOfGreenDucks.add(greenDuck1);
        flockOfGreenDucks.add(greenDuck2);
        flockOfGreenDucks.add(greenDuck3);
        flockOfGreenDucks.add(greenDuck4);

        System.out.println("\nDuck Simulator: Whole Flock Simulation");
        simulate(flockOfDucks);

        System.out.println("\nDuck Simulator: Mallard Flock Simulation");
        simulate(flockOfGreenDucks);

        System.out.println("\nThe ducks quacked " + QuackCounter.getNumberOfQuacks() + " times");
    }

    private void simulate(Quackable duck) {
        duck.quack();
    }
}
