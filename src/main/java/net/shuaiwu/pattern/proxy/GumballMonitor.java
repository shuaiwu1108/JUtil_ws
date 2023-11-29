package net.shuaiwu.pattern.proxy;

import java.io.Serializable;
import java.rmi.RemoteException;
import net.shuaiwu.pattern.state.GumballMachine;

/**
 * 糖果机监控系统
 *
 * @author shuaiwu
 * @date 2023-11-29 9:38
 */
public class GumballMonitor implements Serializable{

    private static final long serialVersionUID = 4644166083418485397L;
    private GumballMachineRemote gumballMachine;

    public GumballMonitor(GumballMachineRemote gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void report() throws RemoteException {
        System.out.println("Gumball Machine:" + gumballMachine.getLocation());
        System.out.println("Current inventory:" + gumballMachine.getCount() + " gumballs");
        System.out.println("Gumball state:" + gumballMachine.getState());
    }
}
