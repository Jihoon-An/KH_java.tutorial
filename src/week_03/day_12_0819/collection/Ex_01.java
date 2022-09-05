package week_03.day_12_0819.collection;

public class Ex_01 {
    public static void main(String[] args) {
        System.out.println("배열 예제");
        String[] arr = new String[10];
        arr[0] = "Hello";
        arr[1] = "World";
        arr[2] = null;

        System.out.println(arr[0]);
        System.out.println(arr[1]);

        arr[2] = arr[1];
        arr[1] = "Hello";

        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);

        System.out.println(arr.length);
    }
}
