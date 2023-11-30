package net.shuaiwu.pattern.mvc;

/**
 * 节拍模型接口
 *
 * @author shuaiwu
 * @date 2023-11-30 10:46
 */
public interface BeatModelInterface {

    void initialize();
    void on();
    void off();
    void setBPM(int bpm);
    int getBPM();

    void registerObserver(BeatObserver o);
    void removeObserver(BeatObserver o);
    void registerObserver(BPMObserver o);
    void removeObserver(BPMObserver o);
}
