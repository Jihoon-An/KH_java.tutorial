package week_06.JDBC.CRUD_01;

import myCustom.Input;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class CRUD_Tutorial{
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("<< 카페 메뉴 관리 프로그램 >>");
            System.out.println("1. 신규 메뉴 등록");
            System.out.println("2. 메뉴 목록 출력");
            System.out.println("0. 프로그램 종료");
            int menu = Input._integer_(0,2);
            String dbIDPW = "kh";

            if (menu == 1) {
                System.out.print("메뉴 이름 : ");
                String pname = Input._string_();
                System.out.print("메뉴 가격 : ");
                int pprice = Input._integer_();
                System.out.print("아이스 가능(Y, N) : ");
                String iced = Input._string_();

                Jhsql sql = new Jhsql();
                int result = sql.update(dbIDPW, dbIDPW, String.format("insert into cafe_menu values(cafe_menu_seq.nextval, '%s', '%d', '%s')", pname, pprice, iced));

                if (result > 0) {
                    System.out.println("입력 성공");
                } else {
                    System.out.println("입력 실패");
                }
            }
            else if(menu == 2){
                Jhsql sql = new Jhsql();
                ArrayList<String> result = sql.query(dbIDPW, dbIDPW, String.format("select * from cafe_menu order by 1"));
                for(String str:result) {
                    System.out.println(str);
                }
            }
            else {
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            }
        }
    }
}

