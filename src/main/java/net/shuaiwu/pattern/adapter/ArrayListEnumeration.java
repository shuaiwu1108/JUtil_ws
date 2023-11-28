package net.shuaiwu.pattern.adapter;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * 列表枚举适配器
 *
 * @author shuaiwu
 * @date 2023-11-28 9:42
 */
public class ArrayListEnumeration implements Enumeration {

    private Iterator iterator;
    public ArrayListEnumeration(Iterator i){
        this.iterator = i;
    }

    @Override
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    @Override
    public Object nextElement() {
        return iterator.next();
    }
}
