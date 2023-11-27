package net.shuaiwu.pattern.command;

/**
 * 打开CD音响命令
 *
 * @author shuaiwu
 * @date 2023-11-27 15:45
 */
public class StereoOnWithCDCommand implements Command{

    private Stereo stereo;
    public StereoOnWithCDCommand(Stereo s){
        this.stereo = s;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }

    @Override
    public void undo() {
        stereo.off();
    }
}
