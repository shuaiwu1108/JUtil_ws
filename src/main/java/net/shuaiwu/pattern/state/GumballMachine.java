package net.shuaiwu.pattern.state;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import net.shuaiwu.pattern.proxy.GumballMachineRemote;

/**
 * 状态机
 *
 * @author shuaiwu
 * @date 2023-11-28 16:20
 */
public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {
    private State soldOutState;
    private State noQuarterState;
    private State hasQuarterState;
    private State soldState;

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public int getCount() {
        return count;
    }

    public State getSoldState() {
        return soldState;
    }

    private State state = soldOutState;
    private int count = 0;

    private String location;

    public GumballMachine(String location, int count) throws RemoteException {
        this.count = count;
        this.location = location;
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        if(count > 0) {
            state = noQuarterState;
        }
    }

    // 投硬币
    public void insertQuarter() {
        state.insertQuarter();
    }

    // 退回硬币
    public void ejectQuarter() {
        state.ejectQuarter();
    }

    // 顾客尝试转动曲柄
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public void setState(State state){
        this.state = state;
    }

    public void releaseBall(){
        System.out.println("出一个糖果");
        if (count != 0) {
            count -= 1;
        }
    }

    @Override
    public String toString() {
        return "GumballMachine{" +
            "state=" + state +
            ", count=" + count +
            '}';
    }

    public void setSoldOutState(State soldOutState) {
        this.soldOutState = soldOutState;
    }

    public void setNoQuarterState(State noQuarterState) {
        this.noQuarterState = noQuarterState;
    }

    public void setHasQuarterState(State hasQuarterState) {
        this.hasQuarterState = hasQuarterState;
    }

    public void setSoldState(State soldState) {
        this.soldState = soldState;
    }

    public State getState() {
        return state;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
