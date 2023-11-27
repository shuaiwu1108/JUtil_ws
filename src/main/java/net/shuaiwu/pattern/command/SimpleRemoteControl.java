package net.shuaiwu.pattern.command;

/**
 * 简单控制器
 *
 * @author shuaiwu
 * @date 2023-11-27 14:38
 */
public class SimpleRemoteControl {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void buttomClick(){
        command.execute();
    }
}
