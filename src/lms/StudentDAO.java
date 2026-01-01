package lms;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.mindrot.jbcrypt.BCrypt;

public class StudentDAO {
	Connection conn = DBconnection.getConnection();
	
	public boolean addAccount(String username, String password) {
		if (username.isBlank() || password.isBlank()) {
			return false;
		}
		if (isUsernameExist(username)) {
			return false;
		}
		String add = "INSERT INTO students (username, password) VALUES (?, ?)";
		try (PreparedStatement addAcc = conn.prepareStatement(add)) {
			// hashing the password
			String hashedpassword = BCrypt.hashpw(password, BCrypt.gensalt());
			addAcc.setString(1, username);
			addAcc.setString(2, hashedpassword);
			// add the new account to the database table if not duplicate
			addAcc.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean isUsernameExist(String username) {
		String sql = "SELECT 1 FROM students WHERE username=?";
		try (PreparedStatement checkUser = conn.prepareStatement(sql)){
			checkUser.setString(1, username);
			try (ResultSet rs = checkUser.executeQuery()){
				return rs.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean isAccountValid(String username, String password) {
		String sql = "SELECT password FROM students WHERE username = ?";
		try (PreparedStatement checkAcc = conn.prepareStatement(sql)) {
			checkAcc.setString(1, username);
			try (ResultSet rs = checkAcc.executeQuery()){
				if (rs.next()) {
					String storedHash = rs.getString("password");
					return BCrypt.checkpw(password, storedHash);
				}
			return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
