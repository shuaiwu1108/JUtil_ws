package net.shuaiwu.pattern.state;


/**
 * 没有投币状态
 *
 * @author shuaiwu
 * @date 2023-11-28 17:04
 */
public class NoQuarterState implements State {

    private GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("你投了硬币");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("没有投币，不能退币");
    }

    @Override
    public void turnCrank() {
        System.out.println("没有投币，不能出糖果");
    }

    @Override
    public void dispense() {
        System.out.println("没有投币，不能发放糖果");
    }
}
