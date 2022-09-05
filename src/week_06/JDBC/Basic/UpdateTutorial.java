package week_06.JDBC.Basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTutorial {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
        String dbID = "kh";
        String dbPW = "kh";
        Connection con = DriverManager.getConnection(dbURL, dbID, dbPW);
        Statement statement = con.createStatement();
        String sql = "Update cafe_menu set pprice = 4500 where pname = 'Americano'";
        int result = statement.executeUpdate(sql);
        if (result > 0) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
        con.commit();
        con.close();
    }
}
