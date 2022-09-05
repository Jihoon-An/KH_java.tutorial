package week_03.day_11_0818.basic;

public class Quiz_01 {
    public static void main(String[] args) {

        Calc c = new Calc();

        System.out.println(c.plus(10, 20));      // 30
        System.out.println(Calc.minus);         // 10
        System.out.println(c.mply(5, 3));       // 15
        System.out.println(Calc.divide(10, 2)); //5
    }

}

class Calc {
    static int minus = 10;

    static int divide(int a, int b) {
        return a / b;
    }

    int mply(int a, int b) {
        return a * b;
    }

    int plus(int a, int b) {
        return a + b;
    }
}
