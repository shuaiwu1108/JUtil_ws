package net.shuaiwu.pattern.iterator;

/**
 * 菜单测试
 *
 * @author shuaiwu
 * @date 2023-11-28 15:29
 */
public class MenuTestDrive {

    public static void main(String[] args) {
        PancakeHouseMenu p = new PancakeHouseMenu();
        DinerMenu d = new DinerMenu();
        Waitress w = new Waitress(p, d);
        w.printMenu();
    }
}
