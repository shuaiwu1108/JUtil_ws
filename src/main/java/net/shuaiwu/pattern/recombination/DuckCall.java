package net.shuaiwu.pattern.recombination;

/**
 * 鸭鸣器
 * <p>
 * 2023/11/29 21:40
 **/
public class DuckCall implements Quackable{
    @Override
    public void quack() {
        System.out.println("Duckcall quack");
    }
}
