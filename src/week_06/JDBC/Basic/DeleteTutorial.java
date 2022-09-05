package week_06.JDBC.Basic;

import java.sql.*;

public class DeleteTutorial {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
        String dbID = "kh";
        String dbPW = "kh";
        Connection con = DriverManager.getConnection(dbURL, dbID, dbPW);

        Statement statement = con.createStatement();

        String sql = "delete from cafe_menu where pname = 'Americano'";
        int result = statement.executeUpdate(sql);
        if(result > 0){
            System.out.println("입력 성공");
        }
        else{
            System.out.println("입력 실패");
        }
        con.commit();
        con.close();
    }
}
