package net.shuaiwu.pattern.command;

/**
 * 卷帘门
 *
 * @author shuaiwu
 * @date 2023-11-27 14:45
 */
public class Door {

    public void up(){
        System.out.println("Door up");
    }

    public void down(){
        System.out.println("Door down");
    }

    public void stop(){
        System.out.println("Door stop");
    }

    public void lightOn(){
        System.out.println("Door light on");
    }

    public void lightOff(){
        System.out.println("Door light off");
    }
}
