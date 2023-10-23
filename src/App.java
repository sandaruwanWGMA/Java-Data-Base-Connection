import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {

    public static void JDBCexample(String userid, String passwd) {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:oracle:thin:@db.yale.edu:1521:univdb",
                        userid, passwd);
                Statement stmt = conn.createStatement();) {
            try {
                stmt.executeUpdate(
                        "insert into instructor values(’77987’,’Kim’,’Physics’,98000)");
            } catch (SQLException sqle) {
                System.out.println("Could not insert tuple. " + sqle);
            }
            ResultSet rset = stmt.executeQuery(
                    "select dept name, avg (salary) " +
                            " from instructor " +
                            " group by dept name");
            while (rset.next()) {
                System.out.println(rset.getString("dept name") + " " +
                        rset.getFloat(2));
            }
        } catch (Exception sqle) {
            System.out.println("Exception : " + sqle);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

}
