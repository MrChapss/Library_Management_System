package lms.security;
// To tell spring that this class produce spring objects to be used in this application
import org.springframework.context.annotation.Configuration;
// Object will be created once and shared in application (managed by spring)
import org.springframework.context.annotation.Bean;
// Annotation that bcrypt the raw string password
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// Interface that hash the password and verify the stored hash in database using raw password
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
// Creating a reusable class that will implement passwordEncoder to other package and classes
public class PasswordEncoderConfig {
	
	@Bean
	// this method uses polymorphism which BCryptPasswordEncoder use PasswordEncoder interface
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
