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
	
	
	public void setId(int id) {this.id=id;}
	public int getId() {return id;}
	
	public void setUsername(String username) {this.username=username;}
	public String getUsername() {return username;}
	 
	public void setPassword(String password) {this.password=password;}
	public String getPassword() {return password;}
	
}
