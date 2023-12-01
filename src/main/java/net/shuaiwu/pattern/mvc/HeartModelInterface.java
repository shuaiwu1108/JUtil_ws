package net.shuaiwu.pattern.mvc;

/**
 * 心跳模型接口
 *
 * @author shuaiwu
 * @date 2023-12-01 8:42
 */
public interface HeartModelInterface {

    int getHeartRate();
    void registerObserver(BeatObserver o);
    void removeObserver(BeatObserver o);
    void registerObserver(BPMObserver o);
    void removeObserver(BPMObserver o);
}
