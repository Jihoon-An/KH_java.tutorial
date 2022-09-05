package week_06.JDBC.Basic;

import java.sql.*;

public class SelectTutorial {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
        String dbID = "kh";
        String dbPW = "kh";
        Connection con = DriverManager.getConnection(dbURL, dbID, dbPW);

        Statement statement = con.createStatement();
        String sql = "select * from cafe_menu order by 1";
        ResultSet result = statement.executeQuery(sql);
        // 4. 실행결과 확인
        while(result.next()) {
            int pid = result.getInt("pid");
            String pname = result.getString("pname");
            int pprice = result.getInt("pprice");
            System.out.println(pid + " : " + pname + " : " + pprice);
        }

        con.close();
    }
}
