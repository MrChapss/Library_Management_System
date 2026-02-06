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
	
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	//Automatic false siguro muna 'to para si 1st Admin na mag bibigay ng access kay other or next admins
	@Column(nullable = false)
	private boolean isAdmin = false;

	public void setId(int id) {this.id=id;}
	public int getId() {return id;}
	
	public void setUsername(String username) {this.username=username;}
	public String getUsername() {return username;}
	 
	public void setPassword(String password) {this.password=password;}
	public String getPassword() {return password;}
	
	public void setIsAdmin(boolean isAdmin) {this.isAdmin=isAdmin;}
	public boolean getIsAdmin() {return isAdmin;}
	
}
