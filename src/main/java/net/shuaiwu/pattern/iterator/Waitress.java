package net.shuaiwu.pattern.iterator;

import java.util.Iterator;

/**
 * 服务员类
 *
 * @author shuaiwu
 * @date 2023-11-28 15:14
 */
public class Waitress {

    private Menu pancakeHouseMenu;
    private Menu dinerMenu;

    public Waitress(Menu pancakeHouseMenu, Menu dinerMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
    }

    public void printMenu(){
        Iterator pancakeHouseMenuIterator = pancakeHouseMenu.createIterator();
        Iterator dinerMenuIterator = dinerMenu.createIterator();

        System.out.println("MENU\n-----\nBREAKFAST");
        printMenu(pancakeHouseMenuIterator);

        System.out.println("\nLUNCH");
        printMenu(dinerMenuIterator);
    }

    private void printMenu(Iterator iterator){
        while (iterator.hasNext()){
            MenuItem next = (MenuItem) iterator.next();
            System.out.println(next);
        }
    }
}
