package net.shuaiwu.pattern.iterator;

import java.util.Iterator;

/**
 * 餐厅菜单迭代器
 *
 * @author shuaiwu
 * @date 2023-11-28 14:57
 */
public class DinerMenuIterator implements Iterator {

    private MenuItem[] items;
    private int position = 0;

    public DinerMenuIterator(MenuItem[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        if (position >= items.length || items[position] == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        MenuItem m = items[position];
        position += 1;
        return m;
    }

    public void remove() {
        if (position <= 0) {
            System.err.println("You can't remove an item until you've done at least one next()");
            return;
        }
        if (items[position - 1] != null) {
            for (int i = position - 1; i < (items.length - 1); i++) {
                items[i] = items[i + 1];
            }
            items[items.length - 1] = null;
        }
    }
}
