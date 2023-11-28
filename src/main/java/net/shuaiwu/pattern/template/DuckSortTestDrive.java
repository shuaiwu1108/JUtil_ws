package net.shuaiwu.pattern.template;

import java.util.Arrays;

/**
 * 鸭子排序测试
 *
 * @author shuaiwu
 * @date 2023-11-28 11:32
 */
public class DuckSortTestDrive {

    public static void main(String[] args) {
        Duck[] ducks = {
            new Duck("Daffy", 8),
            new Duck("Dewey", 2),
            new Duck("Howard", 5),
            new Duck("Louie", 9),
            new Duck("Donald", 1),
            new Duck("Huey", 4),
        };

        System.out.println("Before sorting:");

        display(ducks);

        Arrays.sort(ducks);

        System.out.println("\nAfter sorting:");
        display(ducks);
    }

    public static void display(Duck[] ducks) {
        for (Duck d : ducks) {
            System.out.println(d);
        }
    }
}
