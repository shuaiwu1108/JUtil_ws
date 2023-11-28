package net.shuaiwu.pattern.adapter;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * 枚举适配器
 *
 * @author shuaiwu
 * @date 2023-11-28 9:33
 */
public class EnumerationIterator implements Iterator {

    private Enumeration enumeration;
    public EnumerationIterator(Enumeration e){
        this.enumeration = e;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public Object next() {
        return enumeration.nextElement();
    }
}
