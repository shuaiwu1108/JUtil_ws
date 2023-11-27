package net.shuaiwu.pattern.factory;

/**
 * 披萨类
 *
 * @author shuaiwu
 * @date 2023-11-27 9:58
 */
public class Pizza {

    public void prepare() {
        System.out.println("Pizza prepare");
    }

    public void bake() {
        System.out.println("Pizza bake");
    }

    public void cut() {
        System.out.println("Pizza cut");
    }

    public void box() {
        System.out.println("Pizza box");
    }
}
