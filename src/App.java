import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {

    public static void JDBCexample(String userid, String passwd) {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/JDBC",
                        userid, passwd);
                Statement stmt = conn.createStatement();) {
            try {
                stmt.executeUpdate(
                        "insert into instructor values(175,'Molindu', 'Physics',98500)");
            } catch (SQLException sqle) {
                System.out.println("Could not insert tuple. " + sqle);
            }
            ResultSet rset = stmt.executeQuery(
                    "SELECT dept_id, COUNT(name) AS instructor_count " +
                            "FROM instructor " +
                            " group by dept_id");
            while (rset.next()) {
                System.out.println(rset.getString("dept_id") + " " + rset.getInt(2));
                System.out.println(rset.getInt(0));
            }
        } catch (Exception sqle) {
            System.out.println("Exception : " + sqle);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        JDBCexample("root", "molindu123");
    }

}
