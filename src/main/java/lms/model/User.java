package lms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
// this class act as a table structure

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
	@Builder.Default
	private boolean isAdmin = false;
	
	public boolean blankInputs(String username, String password) {
		if (username.isBlank() || username.equals(null)) {
			return true;
		} if (password.isBlank() || password.equals(null)) {
			return true;
		} else {
			return false;
		}
	}
}
