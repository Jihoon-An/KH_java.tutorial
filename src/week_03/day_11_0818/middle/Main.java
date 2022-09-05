package week_03.day_11_0818.middle;

import java.util.ArrayList;
import java.util.Scanner;

// MVC 중 View, Control

/*
현재 우리가 만든 회원관리 시스템의 3가지 치명적인 문제점
1. 코드 중복도가 높다 > 상속 문법으로 해결
2. 코드 결합도가 높다 > 다형성 문법으로 해결
3. 데이터 저장소 문제 > Collection으로 해결
 */
public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        System.out.println("<< 회원 관리 시스템 >>");
        System.out.println("1. 신규 회원 등록");
        System.out.println("2. 회원 정보 출력");
        System.out.println("3. 종료");
        while (true) {
            int menu = inputInt(1, 3);

            if (menu == 1) {
                manager.addMember(new Silver(1001, "Alice", 1000));
                manager.addMember(new Silver(1002, "Tom  ", 2000));
                manager.addMember(new Silver(1003, "Jason", 3000));
                manager.addMember(new Gold(1004, "Mike", 4000));
                manager.addMember(new Gold(1005, "Elsa", 5000));
            } else if (menu == 2) {
                ArrayList<Member> members = manager.getMembers();

                System.out.println("아이디\t이름\t포인트\t보너스");
                for (Member i : members) {
                    System.out.println(i.getId() + "\t" +
                            i.getName() + "\t" +
                            i.getPoint() + "\t" +
                            i.getBonus() + "\t" +
                            i.getType());
                }
            }
            else {
                System.exit(0);
            }
        }
    }
    static int inputInt() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(">>> ");
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다, 정수를 입력하세요.");
            }
        }
    }

    static int inputInt(int min, int max) {
        int input_num = inputInt();
        while (true) {
            if (min <= input_num && input_num <= max) {
                return input_num;
            } else {
                System.out.println("범위 밖의 입력입니다.");
            }
        }
    }

    static String inputStr() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(">>>");
        return scanner.nextLine();
    }
}
