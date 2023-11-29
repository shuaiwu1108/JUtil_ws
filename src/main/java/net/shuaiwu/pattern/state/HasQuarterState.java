package net.shuaiwu.pattern.state;

/**
 * 已投币状态
 *
 * @author shuaiwu
 * @date 2023-11-28 17:13
 */
public class HasQuarterState implements State{
    private transient GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("已经投币，不能再次投币");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("退还硬币");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("你转动了曲柄...");
        gumballMachine.setState(gumballMachine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("不能出糖果");
    }
}
