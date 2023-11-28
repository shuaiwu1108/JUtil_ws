package net.shuaiwu.pattern.iterator;

import java.util.Iterator;

/**
 * 餐厅菜单
 *
 * @author shuaiwu
 * @date 2023-11-28 14:41
 */
public class DinerMenu implements Menu{

    private static final int MAX_ITEMS = 6;
    private int numberOfItems = 0;

    private MenuItem[] menuItems;

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem m = new MenuItem(name, description, vegetarian, price);
        if (numberOfItems >= MAX_ITEMS) {
            System.err.println("Sorry, menu is full! Can't add item to menu");
        } else {
            menuItems[numberOfItems] = m;
            numberOfItems += 1;
        }
    }

    public Iterator createIterator(){
        return new DinerMenuIterator(menuItems);
    }

    public DinerMenu(){
        menuItems = new MenuItem[MAX_ITEMS];
        addItem("Vegetarian BLT", "(Fakin) Bacon with lettuce & tomato on whole wheat", true, 2.99);
        addItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99);
        addItem("Soup of day", "Soup of the day, with a side of potato salad", false, 3.29);
        addItem("Hotdog", "A hot dog, with saurkraut, relish, onions, topped with cheese", false, 3.05);
    }
}
