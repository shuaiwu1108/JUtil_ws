package net.shuaiwu.pattern.template;

/**
 * 咖啡因饮料测试类
 *
 * @author shuaiwu
 * @date 2023-11-28 11:19
 */
public class CaffeineTestDrive {

    public static void main(String[] args) {
        Tea t = new Tea();
        t.prepareRecipe();

        System.out.println("\n====================");

        Coffee c = new Coffee();
        c.prepareRecipe();
    }
}
