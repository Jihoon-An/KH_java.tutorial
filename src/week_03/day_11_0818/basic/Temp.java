package week_03.day_11_0818.basic;

public class Temp {
    public int a;           // Instance Member Field    - Instance가 생성될 때 메모리에 할당된다.
    public static int b;    // Class Member Field       - main이 실행될 때 메모리에 할당된다.

    public void funcA(){
        a = 10;
        b = 10;
    }
    public void funcB(){
        a = 30;
        b = 40;
    }
}
