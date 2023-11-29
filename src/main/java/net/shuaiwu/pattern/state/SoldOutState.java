package net.shuaiwu.pattern.state;


/**
 * 已售罄状态
 *
 * @author shuaiwu
 * @date 2023-11-28 17:12
 */
public class SoldOutState implements State {

    private transient GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("已售罄，不能投币");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("已售罄，不可能退币");
    }

    @Override
    public void turnCrank() {
        System.out.println("已售罄，不能转动曲柄");
    }

    @Override
    public void dispense() {
        System.out.println("已售罄，这是个不恰当的操作");
    }
}
