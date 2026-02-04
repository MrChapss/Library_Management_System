package lms.dao;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

import lms.utility.DBConnection;

@Repository
public class Book_Service {
	final private Connection conn = DBConnection.getConnection();
	
	public void addBook(String book_name, int book_id) {
		final String sql = "INSERT INTO LMS(BOOK_NAME, BOOK_ID) VALUES (?,?)";
		try(PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, book_name);
			ps.setInt(2, book_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// testing
}
