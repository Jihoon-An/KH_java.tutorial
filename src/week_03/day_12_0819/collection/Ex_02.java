package week_03.day_12_0819.collection;

import java.util.ArrayList;

public class Ex_02 {
    public static void main(String[] args) {
        System.out.println("ArrayList 예제");
        ArrayList arr = new ArrayList();
        arr.add("Hello");
        arr.add("World");
        arr.add("Collection");

        arr.remove(0);

        System.out.println(arr.get(0));
        System.out.println(arr.get(1));

        arr.add(1, "Hello");
        System.out.println(arr.get(0));
        System.out.println(arr.get(1));

        System.out.println(arr.size());
    }
}
