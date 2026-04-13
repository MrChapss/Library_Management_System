package lms.model;

import java.time.Instant;
// Collection is a framework of java and a set of interfaces (list)
import java.util.Collection;
//
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

// @Builder annotation - To simplify creation of builder pattern (in short, reduce boilerplate code)
import lombok.Builder;
// @Setter annotation - setter method
import lombok.Setter;
// @Getter annotation - getter method
import lombok.Getter;
// @NoArgsConstructor - For hibernate to create empty constructor
import lombok.NoArgsConstructor;
// @AllArgsConstructor - For user to create a book immediately if all fields are complete
import lombok.AllArgsConstructor;
//
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.userdetails.UserDetails;
// what are these imports? what for?
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
// this class act as a table structure in database
public class User implements UserDetails{
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
	private Instant createdAt;
	@Column(nullable = false)
	private Instant lastLoginAt;

	// Giving context to spring boot what kind of roles have in the database
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(){
		// Name of roles
		String admin = "ROLE_ADMIN";
		String user = "ROLE_USER";
		// Giving authority in based on name of the role (ROLE_ADMIN)
		GrantedAuthority authority;
		if (isAdmin){
			authority = new SimpleGrantedAuthority(admin);
		} else {
			authority = new SimpleGrantedAuthority(user);
		}
		return List.of(authority);
	}
	// Add @Override account status methods (later)

}
