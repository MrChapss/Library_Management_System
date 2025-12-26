package lms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBconnection {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Library_Management_System",
					"root",
					""
				);
			//System.out.println("Connected successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
