package lms.security;

// purpose??
import org.springframework.context.annotation.Bean;
// purpose??
import org.springframework.context.annotation.Configuration;
// purpose??
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// purpose??
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
// purpose??
import org.springframework.security.config.http.SessionCreationPolicy;
// purpose??
import org.springframework.security.web.SecurityFilterChain;
// shorcut way for requestMatcher where POST method where only authenticated or allowed,
// instead adding its method path which is hassle
import org.springframework.http.HttpMethod;

@Configuration
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http,
												   JwtFilter jwtFilter) throws Exception {
		http
			.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
			.sessionManagement(session -> session
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.csrf(csrf -> csrf
					.disable())
			.authorizeHttpRequests(auth -> auth
					.requestMatchers(HttpMethod.POST,
							"/LMS/register",
							"/LMS/login").permitAll()
					.anyRequest().authenticated()
			);
		return http.build();
	}
}
