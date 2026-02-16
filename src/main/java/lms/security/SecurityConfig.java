package lms.security;
// What is the purpose of configuration annotation?
import org.springframework.context.annotation.Configuration;
// What is the purpose of bean annotation in this class?
import org.springframework.context.annotation.Bean;
// The purpose of BCryptPasswordEncoder is to encrypt the password immediately since its already pre-built
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// What is the purpose of password encoder in this class?
// Also, what's the difference between BCryptPasswordEncoder to PasswordEncoder?
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
