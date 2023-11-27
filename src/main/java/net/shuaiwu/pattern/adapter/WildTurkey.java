package net.shuaiwu.pattern.adapter;

/**
 * 火鸡
 *
 * @author shuaiwu
 * @date 2023-11-27 16:32
 */
public class WildTurkey implements Turkey{

    @Override
    public void gobble() {
        System.out.println("WildTurkey gobble");
    }

    @Override
    public void fly() {
        System.out.println("WildTurkey fly");
    }
}
