package net.shuaiwu.pattern.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 煎饼屋菜单
 *
 * @author shuaiwu
 * @date 2023-11-28 14:29
 */
public class PancakeHouseMenu implements Menu{

    private ArrayList menuItems;

    public void addItem(String name, String description, boolean vegetarian, double price){
        MenuItem m = new MenuItem(name, description, vegetarian, price);
        menuItems.add(m);
    }


    public Iterator createIterator(){
        return menuItems.iterator();
    }

    public PancakeHouseMenu(){
        menuItems = new ArrayList();
        addItem("K&B's Pancake Breakfast", "Pancakes with scrambled eggs, and toast", true, 2.99);
        addItem("Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false, 2.99);
        addItem("BlueBerry Pancake Breakfast", "Pancakes made with fresh blueberries", true, 3.49);
        addItem("Waffles", "Waffles, with your choice of blueberry or strawberries", true, 3.59);
    }
}
