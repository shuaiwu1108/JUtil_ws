package net.shuaiwu.pattern.proxy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * 糖果机监控测试
 *
 * @author shuaiwu
 * @date 2023-11-29 10:11
 */
public class GumballMonitorTestDrive {

    public static void main(String[] args)
        throws MalformedURLException, NotBoundException, RemoteException {
        String url = "rmi://localhost:1900/gumballmachine";
        GumballMachineRemote r = (GumballMachineRemote) Naming.lookup(url);
        GumballMonitor gm = new GumballMonitor(r);
        gm.report();
    }
}
