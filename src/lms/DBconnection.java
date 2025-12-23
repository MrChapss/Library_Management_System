package lms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBconnection {
	 // Method to get the connection
    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testingDB?useSSL=false&serverTimezone=UTC",
                "root",
                ""
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
