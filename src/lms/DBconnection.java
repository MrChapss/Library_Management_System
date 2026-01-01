package lms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBconnection {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			String link = "jdbc:mysql://localhost:3306/Library_Management_System";
			String user = "root";
			String password = "";
			conn = DriverManager.getConnection(link, user, password);
			//System.out.println("Connected successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
