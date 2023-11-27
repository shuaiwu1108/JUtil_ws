package net.shuaiwu.pattern.command;

/**
 * 遥控器
 *
 * @author shuaiwu
 * @date 2023-11-27 15:42
 */
public class RemoteLoader {

    public static void main(String[] args) {
        RemoteControl rc = new RemoteControl();

        Light l = new Light();
        Door d = new Door();
        Stereo s = new Stereo();

        Command c = new NoCommand();

        LightOnCommand lon = new LightOnCommand(l);
        LightOffCommand loff = new LightOffCommand(l);

        DoorOpenCommand don = new DoorOpenCommand(d);

        StereoOnWithCDCommand scc = new StereoOnWithCDCommand(s);

        rc.setCommand(0, lon, loff);
        rc.setCommand(1, don, c);
        rc.setCommand(2, scc, c);

        System.out.println(rc);

        rc.onButtonClick(0);
        rc.undoButtomClick();

        rc.offButtonClick(0);

        rc.onButtonClick(1);
        rc.undoButtomClick();

        rc.onButtonClick(2);
    }
}
