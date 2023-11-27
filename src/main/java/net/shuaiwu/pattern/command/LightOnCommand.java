package net.shuaiwu.pattern.command;

/**
 * 开灯命令
 *
 * @author shuaiwu
 * @date 2023-11-27 14:35
 */
public class LightOnCommand implements Command{
    private Light light;

    public LightOnCommand(Light l){
        this.light = l;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
