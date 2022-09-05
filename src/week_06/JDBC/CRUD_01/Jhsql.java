package week_06.JDBC.CRUD_01;

import java.sql.*;
import java.util.ArrayList;

class Jhsql {
    int update(String dbID, String dbPW, String sql) throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
        try(
                Connection con = DriverManager.getConnection(dbURL, dbID, dbPW);
                ) {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);

            con.commit();

            return result;
        } catch (Exception e){
            return 0;
        }
    }

    ArrayList<String> query(String dbID, String dbPW, String sql) throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
        ArrayList<String> outStr = new ArrayList<>();
        try(
                Connection con = DriverManager.getConnection(dbURL, dbID, dbPW);
                ) {
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                int pid = result.getInt("pid");
                String pname = result.getString("pname");
                int pprice = result.getInt("pprice");
                String iced = result.getString("iced");

                outStr.add(pid + " : " + pname + " : " + pprice + "\t: " + iced);
            }
            return outStr;
        }catch (Exception e){
            return null;
        }
    }
}
