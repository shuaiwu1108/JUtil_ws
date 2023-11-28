package net.shuaiwu.pattern.template;

import java.awt.Graphics;
import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 * JFrame窗体程序
 *
 * @author shuaiwu
 * @date 2023-11-28 11:45
 */
public class MyFrame extends JFrame {

    public MyFrame(String title) throws HeadlessException {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(300, 300);
        this.setVisible(true);
    }

    public void paint(Graphics graphics){
        super.paint(graphics);
        String msg = "I rule!!";
        graphics.drawString(msg, 100, 100);
    }

    public static void main(String[] args) {
        MyFrame myFarme = new MyFrame("Head First Design Patterns");
    }
}
