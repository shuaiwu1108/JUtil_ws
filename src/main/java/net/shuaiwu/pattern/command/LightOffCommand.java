package net.shuaiwu.pattern.command;

/**
 * 关灯命令
 *
 * @author shuaiwu
 * @date 2023-11-27 15:37
 */
public class LightOffCommand implements Command{

    private Light light;
    public LightOffCommand(Light l){
        this.light = l;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
