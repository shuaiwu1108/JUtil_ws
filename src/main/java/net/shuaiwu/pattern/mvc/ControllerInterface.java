package net.shuaiwu.pattern.mvc;

/**
 * 控制器接口
 * <p>
 * 2023/11/30 21:36
 **/
public interface ControllerInterface {
    void start();
    void stop();
    void setBPM(int bpm);
    void increaseBPM();
    void decreaseBPM();
}
