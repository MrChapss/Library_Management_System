package lms.utility;

import java.sql.*;

public class DBConnection {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			String url = "jdbc:h2:file:./data/LMS_DB";
			String user = "";
			String password = "";
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
