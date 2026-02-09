package lms.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateAccountRequest {
	
	private int id;
	@NotBlank(message="Username must not be empty")
	private String username;
	@NotBlank(message="Password must not be empty" )
	private String password;
	
	public void setId(int id) {this.id=id;}
	public int getId() {return id;}
	
	public void setUsername(String username) {this.username=username;}
	public String getUsername() {return username;}
	
	public void setPassword(String password) {this.password=password;}
	public String getPassword() {return password;}
	
	// KAILANGAN INTIDIHIN KO PURPOSE NITONG PACKAGE NA 'TO
	// MAG KAKAIBA PURPOSE PALA NITO HINDI SIYA "ONE FOR ALL"
}
