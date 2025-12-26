package lms;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.mindrot.jbcrypt.BCrypt;

public class StudentDAO {
	Connection conn = DBconnection.getConnection();
	
	public boolean addAccount(String username, String password) {
		String add = "INSERT INTO students (username, password) VALUES (?, ?)";
		try {
			if (this.isAccountValid(username, password)) {
				return false;
			}
			// add the new acc to the db if not duplicate
			PreparedStatement addAcc = conn.prepareStatement(add);
			// hashing the password
			String hashedpassword = BCrypt.hashpw(password, BCrypt.gensalt());
			addAcc.setString(1, username);
			addAcc.setString(2, hashedpassword);
			addAcc.executeUpdate();
			addAcc.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean isAccountValid(String username, String password) {
		String sql = "SELECT password FROM students WHERE username = ?";
		try {
			PreparedStatement checkAcc = conn.prepareStatement(sql);
			checkAcc.setString(1, username);
			ResultSet rs = checkAcc.executeQuery();
			
			if (rs.next()) {
				String storedHash = rs.getString("password");
				return BCrypt.checkpw(password, storedHash);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
}
