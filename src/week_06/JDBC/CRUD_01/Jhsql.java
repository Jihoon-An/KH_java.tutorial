package week_06.JDBC.CRUD_01;

import java.sql.*;
import java.util.ArrayList;

class Jhsql {
    int update(String dbID, String dbPW, String sql) throws ClassNotFoundException, SQLException {
        // 1. DBMS 라이브러리 등록하기.
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // 2. DBMS 접속하기.
        String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection con = DriverManager.getConnection(dbURL, dbID, dbPW);

        // 3. Query 전달 인스턴스 생성
        Statement statement = con.createStatement();
        // sql 전송
        int result = statement.executeUpdate(sql);

        // 5. 마무리 작업 commit & close
        con.commit();
        con.close();

        return result;
    }

    ArrayList<String> query(String dbID, String dbPW, String sql) throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection con = DriverManager.getConnection(dbURL, dbID, dbPW);

        ArrayList<String> outStr =  new ArrayList<>();

        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while(result.next()) {
            int pid = result.getInt("pid");
            String pname = result.getString("pname");
            int pprice = result.getInt("pprice");
            String iced = result.getString("iced");
            outStr.add(pid + " : " + pname + " : " + pprice + " : " + iced);
        }
        con.close();
        return outStr;
    }
}
