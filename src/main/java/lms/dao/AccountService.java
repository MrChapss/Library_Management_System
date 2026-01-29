package lms.dao;

import java.sql.*;
import org.springframework.stereotype.*;
import lms.utility.DBConnection;

@Repository
public class AccountService {
	final Connection conn = DBConnection.getConnection();
	
	public void createAcc(String username, String password) throws SQLException {
		try(PreparedStatement ps = conn.prepareStatement(
				"INSERT INTO LMS(USER_NAME, PASSWORD) VALUES (?, ?)"
				)){
			ps.setString(1, username);
			ps.setString(2, password);
			ps.executeUpdate();
		}
	}
}
