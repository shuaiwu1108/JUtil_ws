package net.shuaiwu.pattern.state;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * 糖果机测试
 *
 * @author shuaiwu
 * @date 2023-11-28 16:50
 */
public class GumballMachineTestDrive {

    public static void main(String[] args) {
        GumballMachine g = null;
        try {
            g = new GumballMachine("wuhan", 5);
            LocateRegistry.createRegistry(1900);
            Naming.rebind("rmi://localhost:1900/gumballmachine", g);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(g);

        g.insertQuarter();
        g.turnCrank();

        System.out.println(g);

        g.insertQuarter();
        g.ejectQuarter();
        g.turnCrank();

        System.out.println(g);

        g.insertQuarter();
        g.turnCrank();
        g.insertQuarter();
        g.turnCrank();
        g.ejectQuarter();

        System.out.println(g);

        g.insertQuarter();
        g.insertQuarter();
        g.turnCrank();
        g.insertQuarter();
        g.turnCrank();
        g.insertQuarter();
        g.turnCrank();

        System.out.println(g);
    }
}
