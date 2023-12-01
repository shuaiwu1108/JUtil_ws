package net.shuaiwu.pattern.mvc;

import javax.swing.JProgressBar;

/**
 * 节拍条
 * <p>
 * 2023/11/30 21:36
 **/
public class BeatBar extends JProgressBar implements Runnable {
    private static final long serialVersionUID = 2L;
    Thread thread;

    public BeatBar() {
        thread = new Thread(this);
        setMaximum(100);
        thread.start();
    }

    public void run() {
        for(;;) {
            int value = getValue();
            value = (int)(value * .75);
            setValue(value);
            repaint();
            try {
                Thread.sleep(50);
            } catch (Exception e) {};
        }
    }
}