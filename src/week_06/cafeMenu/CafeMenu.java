package week_06.cafeMenu;

import myCustom.Input;

import java.util.ArrayList;
import java.util.Scanner;

public class CafeMenu {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("\n<< 카페 메뉴 관리 프로그램 >>");
            System.out.println("1. 신규 메뉴 등록");
            System.out.println("2. 메뉴 목록 출력");
            System.out.println("3. 메뉴 정보 삭제 (상품코드로 삭제)");
            System.out.println("4. 메뉴 정보 수정 (상품코드로 변경)");
            System.out.println("0. 프로그램 종료");
            int menu = Input._integer_(0,4);
            String dbIdPw = "kh";

            if (menu == 1) {
                CafeMenuDAO ppsql = new CafeMenuDAO();

                System.out.print("메뉴 이름 입력.");
                String pname = Input._string_();
                System.out.print("메뉴 가격 입력.");
                String pprice = Input._string_();
                System.out.print("아이스 가능(Y, N) 입력.");
                String iced = Input._string_("Y","N");

                int result = ppsql.insert(pname, pprice, iced);

                if (result > 0) {
                    System.out.println("입력 성공");
                } else {
                    System.out.println("입력 실패");
                }
            }
            else if(menu == 2){
                CafeMenuDAO ppsql = new CafeMenuDAO();
                ArrayList<String> result = ppsql.select();
                if(result == null){
                    System.out.println("Contents가 존재하지 않습니다.");
                    continue;
                }
                System.out.println("pid \t: pname \t: pprice \t: iced");
                for(String str:result) {
                    System.out.println(str);
                }
            }
            else if(menu == 3){
                CafeMenuDAO ppsql = new CafeMenuDAO();
                // 삭제 ID 입력
                System.out.print("삭제할 메뉴 ID 입력.");
                int pid = Input._integer_();

                // sql 입력
                int result = ppsql.delete(pid);

                if (result > 0) {
                    System.out.println("삭제 성공!!");
                } else {
                    System.out.println("삭제 대상이 없습니다.");
                }
            }
            else if(menu == 4){
                CafeMenuDAO ppsql = new CafeMenuDAO();
                // 수정 ID 입력
                System.out.print("수정할 메뉴 ID 입력.");
                int pid = Input._integer_();

                // 수정할 컬럼 내용 출력
                String result_sel = String.valueOf(ppsql.select(pid));
                System.out.println("pid : pname : pprice : iced");
                if(result_sel == null){
                    System.out.println("해당 ID는 존재하지 않습니다.");
                    continue;
                }

                System.out.println(result_sel);

                // 수정 컬럼 입력
                System.out.print("수정할 컬럼 : ");
                String colName = Input._string_();

                // 수정 내용 입력
                String content = "";
                if(colName.equals("iced")){
                    System.out.print("수정 내용 입력.");
                    content = Input._string_("Y", "N");
                }else {
                    System.out.print("수정 내용 입력.");
                    content = Input._string_();
                }

                // sql 입력
                int result = 0;
                try {
                    result = ppsql.update(colName, content, pid);
                } catch (Exception e){
                    e.printStackTrace();
                    System.out.println("같은 오류가 반복되면 관리자에게 문의하세요.");
                }

                if (result > 0) {
                    System.out.println("수정 성공!!");
                } else {
                    System.out.println("수정 대상이 없습니다.");
                }
            }
            else {
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            }
        }
    }
}

