package lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;
import lms.utility.DBConnection;

@Repository
public class AccountService {
	final Connection conn = DBConnection.getConnection();
	
	public void createAcc(String username, String password) {
		try(PreparedStatement ps = conn.prepareStatement(
				"INSERT INTO LMS(USER_NAME, PASSWORD) VALUES (?, ?)"
				)){
			ps.setString(1, username);
			ps.setString(2, password);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
