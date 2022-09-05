package week_06.cafeMenu;

import java.sql.*;
import java.util.ArrayList;

class CafeMenuDAO {
    private String dbID = "kh";
    private String dbPW = "kh";
    private String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";

    public String getDbID() {
        return dbID;
    }

    public void setDbID(String dbID) {
        this.dbID = dbID;
    }

    public String getDbPW() {
        return dbPW;
    }

    public void setDbPW(String dbPW) {
        this.dbPW = dbPW;
    }

    public String getDbURL() {
        return dbURL;
    }

    public void setDbURL(String dbURL) {
        this.dbURL = dbURL;
    }

    public CafeMenuDAO() {
    }

    public CafeMenuDAO(String dbID, String dbPW) {
        this.dbID = dbID;
        this.dbPW = dbPW;
    }

    int insert(String... contents) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
        String sql = "insert into cafe_menu values(cafe_menu_seq.nextval, ?, ?, ?)";
        try (
                Connection con = DriverManager.getConnection(dbURL, dbID, dbPW);
        ) {
            PreparedStatement statement = con.prepareStatement(sql);
            int i = 1;
            for (String content : contents) {
                statement.setString(i++, content);
            }
            int result = statement.executeUpdate();

            con.commit();

            return result;
        } catch (Exception e) {
            return 0;
        }
    }

    int delete(int pid) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
        String sql = "delete from cafe_menu where pid = ?";
        try (
                Connection con = DriverManager.getConnection(dbURL, dbID, dbPW);
        ) {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, pid);
            int result = statement.executeUpdate();

            con.commit();

            return result;
        } catch (Exception e) {
            return 0;
        }
    }

    ArrayList<String> select() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
        String sql = "select * from cafe_menu order by 1";
        ArrayList<String> outStr = new ArrayList<>();
        try (
                Connection con = DriverManager.getConnection(dbURL, dbID, dbPW);
        ) {
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int pid = result.getInt("pid");
                String pname = result.getString("pname");
                int pprice = result.getInt("pprice");
                String iced = result.getString("iced");

                outStr.add(pid + " : " + pname + " : " + pprice + "\t: " + iced);
            }
            return outStr;
        } catch (Exception e) {
            return null;
        }
    }

    String select(int id) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
        String outStr = "";
        String sql = "select * from cafe_menu where pid = ? order by 1";
        try (
                Connection con = DriverManager.getConnection(dbURL, dbID, dbPW);
        ) {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            result.next();
            int pid = result.getInt("pid");
            String pname = result.getString("pname");
            int pprice = result.getInt("pprice");
            String iced = result.getString("iced");

            outStr = pid + " : " + pname + " : " + pprice + " : " + iced;

            return outStr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    int update(String colName, String content, int pid) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
        String sql = "Update cafe_menu set ? = ? where pid = ?";
        try (
                Connection con = DriverManager.getConnection(dbURL, dbID, dbPW);
        ) {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, colName);
            statement.setString(2, content);
            statement.setInt(3, pid);
            int result = statement.executeUpdate();

            con.commit();

            return result;
        } catch (Exception e) {
            return 0;
        }
    }
}
