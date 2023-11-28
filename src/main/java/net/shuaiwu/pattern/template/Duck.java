package net.shuaiwu.pattern.template;

/**
 * 鸭子类
 *
 * @author shuaiwu
 * @date 2023-11-28 11:27
 */
public class Duck implements Comparable {

    private String name;
    private int weight;

    public Duck(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Duck{" +
            "name='" + name + '\'' +
            ", weight=" + weight +
            '}';
    }

    @Override
    public int compareTo(Object o) {
        Duck tmp = (Duck) o;
        return Integer.compare(this.weight, tmp.weight); // 顺序排列
    }
}
