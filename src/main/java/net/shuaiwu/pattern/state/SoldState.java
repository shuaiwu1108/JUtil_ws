package net.shuaiwu.pattern.state;

/**
 * 正在出售状态
 *
 * @author shuaiwu
 * @date 2023-11-28 17:14
 */
public class SoldState implements State{
    private transient GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }


    @Override
    public void insertQuarter() {
        System.out.println("正在出糖果，不能继续投币");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("你已经转动了曲柄，无法退币");
    }

    @Override
    public void turnCrank() {
        System.out.println("已经转动了曲柄，不能再次转动曲柄");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
}
