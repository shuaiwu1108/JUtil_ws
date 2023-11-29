package net.shuaiwu.pattern.recombination;

/**
 * 鹅适配器
 * <p>
 * 2023/11/29 21:53
 **/
public class GooseAdapter implements Quackable{
    private Goose goose;

    public GooseAdapter(Goose goose) {
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk();
    }
}
