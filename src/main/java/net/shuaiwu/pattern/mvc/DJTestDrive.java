package net.shuaiwu.pattern.mvc;

/**
 * DJ测试
 * <p>
 * 2023/11/30 21:57
 **/
public class DJTestDrive {
    public static void main(String[] args) {
        BeatModelInterface model = new BeatModel();
        ControllerInterface controller = new BeatController(model);
    }
}
