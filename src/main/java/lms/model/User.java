package lms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
// this class act as a table structure
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//Automatic false siguro muna 'to para si 1st Admin na mag bibigay ng access kay other or next admins
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private boolean isAdmin = false;
	
	// setter
	public void setId(int id) {this.id=id;}
	public void setUsername(String username) {this.username=username;}
	public void setPassword(String password) {this.password=password;}
	public void setIsAdmin(boolean isAdmin) {this.isAdmin=isAdmin;}
	// getter
	public int getId() {return id;}
	public String getUsername() {return username;}
	public String getPassword() {return password;}
	public boolean getIsAdmin() {return isAdmin;}
	
	public boolean blankInputs(String username, String password) {
		if (username.isBlank() || username.equals(null)) {
			return false;
		} if (password.isBlank() || password.equals(null)) {
			return false;
		} else {
			return true;
		}
	}
}
