package week_03.day_12_0819.midlevel;

class A{
    public void funcA(){
        System.out.println("A입니다.");
    }
}
class B extends A{
    public void funcA(){
        System.out.println("B입니다.");
    }
}

public class Example {
    public static void main(String[] args) {
        A a = new B();
        a.funcA(); //B에 있는 funcA
        ((B)a).funcA(); //B에 있는 funcA
    }
}
