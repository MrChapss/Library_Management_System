package lms.dao;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import lms.utility.DBConnection;

@Repository
public class Account_Service {
	private final Connection conn = DBConnection.getConnection();
	
	public void createAccount(String username, String password) {
		final String sql = "INSERT INTO LMS(USER_NAME, PASSWORD_HASH) VALUES (?, ?)";
		try(PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, username);
			ps.setString(2, password);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAccount(String username) {
		final String sql = "DELETE FROM LMS WHERE USER_NAME = ?";
		try(PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, username);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateAccount(int id, String username, String password) {
		final String sql = "UPDATE LMS SET USER_NAME = ?, PASSWORD_HASH = ? WHERE ID = (?)";
		try(PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setInt(3, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isUsernameExist(String username) {
		final String sql = "SELECT 1 FROM LMS WHERE USER_NAME = ?";
		try(PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, username);
			try (ResultSet rs = ps.executeQuery()){
				return rs.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
	}
	
	public boolean emptyInputs(String username, String password) {
		if (username.isBlank() || password.isBlank()) {
			return false;
		} else {
			return true;
		}
	}
	
}
