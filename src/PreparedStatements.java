import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatements {
  public static void JDBCexample(String userid, String passwd) {
    try (
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/JDBC",
            userid, passwd);) {
      try (PreparedStatement pstmt = conn.prepareStatement("SELECT id FROM instructor WHERE id>=?");) {
        pstmt.setInt(1, 3);
        // pstmt.setInt(1, 2);

        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
          System.out.println(rs.getInt(1));
        }
      } catch (SQLException se) {
        System.out.println(se);
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
