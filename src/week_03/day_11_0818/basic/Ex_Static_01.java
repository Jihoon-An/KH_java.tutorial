package week_03.day_11_0818.basic;

public class Ex_Static_01 {
    public static void main(String[] args) {
        Temp temp = new Temp();

        //int a에 값 넣기
        temp.a = 10;
        //static int b에 값 넣기
        Temp.b = 10;

        Temp temp1 = new Temp();

        temp1.b = 20;

        System.out.println(temp.b);


    }
}
