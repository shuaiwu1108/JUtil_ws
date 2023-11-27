package net.shuaiwu.pattern.adapter;

import net.shuaiwu.pattern.strategy.Duck;

/**
 * 火鸡适配器
 *
 * @author shuaiwu
 * @date 2023-11-27 16:33
 */
public class TurkeyAdapter implements Duck {
    private Turkey turkey;
    public TurkeyAdapter(Turkey turkey){
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}
