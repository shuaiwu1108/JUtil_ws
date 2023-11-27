package net.shuaiwu.pattern.command;

/**
 * 简单控制器测试
 *
 * @author shuaiwu
 * @date 2023-11-27 14:41
 */
public class RemoteControlTest {

    public static void main(String[] args) {
        SimpleRemoteControl s = new SimpleRemoteControl();
        Light l = new Light();
        Door d = new Door();
        LightOnCommand lom = new LightOnCommand(l);
        DoorOpenCommand doc = new DoorOpenCommand(d);

        s.setCommand(lom);
        s.buttomClick();
        s.setCommand(doc);
        s.buttomClick();
    }
}
