package net.shuaiwu.pattern.iterator;

/**
 * 菜单项
 *
 * @author shuaiwu
 * @date 2023-11-28 14:23
 */
public class MenuItem {

    private String name;
    private String description;
    private boolean vegetarian;
    private double price;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public double getPrice() {
        return price;
    }

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
            "name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", vegetarian=" + vegetarian +
            ", price=" + price +
            '}';
    }
}
