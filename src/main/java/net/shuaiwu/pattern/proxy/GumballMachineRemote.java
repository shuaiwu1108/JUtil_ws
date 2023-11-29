package net.shuaiwu.pattern.proxy;

import java.rmi.Remote;
import java.rmi.RemoteException;
import net.shuaiwu.pattern.state.State;

/**
 * 糖果机远程调用
 *
 * @author shuaiwu
 * @date 2023-11-29 9:59
 */
public interface GumballMachineRemote extends Remote {

    int getCount() throws RemoteException;
    String getLocation() throws RemoteException;
    State getState() throws RemoteException;
}
