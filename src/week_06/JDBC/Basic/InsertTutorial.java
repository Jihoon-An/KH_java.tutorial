package week_06.JDBC.Basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTutorial {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // 1. DBMS 라이브러리 등록하기.
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // 2. DBMS 접속하기.
        String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
        String dbID = "kh";
        String dbPW = "kh";
        Connection con = DriverManager.getConnection(dbURL, dbID, dbPW);

        // 3. Query 전달 인스턴스 생성
        Statement statement = con.createStatement();
        // sql 작성
        String sql = "insert into cafe_menu values(cafe_menu_seq.nextval, 'ColdBrew', 4000, 'Y')";
        // sql 전송
        int result = statement.executeUpdate(sql);

        // 4. 실행결과 확인
        if(result > 0) {
            System.out.println("입력 성공");
        }else {
            System.out.println("입력 실패");
        }

        // 5. 마무리 작업 commit & close
        con.commit();
        con.close();
    }
}
