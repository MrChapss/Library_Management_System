package lms.service;

import lms.exception.*;
import lms.exception.IllegalArgumentException;
import lms.security.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
// the userDetails is an interface representing the user (its like abstracting the user model class)
// the userDetailsService for retrieving some details
import org.springframework.security.core.userdetails.UserDetailsService;
// throws exception if username not found
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.Authentication;

import lms.model.User;
import lms.dto.RegisterResponseDTO;
import lms.dto.LoginResponseDTO;
import lms.dto.TokenStatus;
import lms.repository.AccountRepository;

import jakarta.transaction.Transactional;

import java.time.Instant;

@Service
public class AccountService implements UserDetailsService{
	private final AccountRepository accountRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;

	public AccountService (AccountRepository accountRepository,
						   PasswordEncoder passwordEncoder,
						   JwtService jwtService){
		this.accountRepository=accountRepository;
		this.passwordEncoder=passwordEncoder;
		this.jwtService=jwtService;
	}
	// Get the username in account repository class (for JwtFilter to work)
	// hindi ako sure pano na accept ng user model yung userDetails interface gamit ng GrantedAuthority
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException{
		if (username == null){
			throw new UsernameNotFoundException("The username does not exist!");
		} else {
			return accountRepository.findUserByUsername(username);
		}
	}
	public RegisterResponseDTO createAccount(String username, String password) {
		if (blankInputs(username, password)){
			throw new IllegalArgumentException("The username or password cannot be empty!");
		} if (isUsernameExist(username)){
			throw new UsernameAlreadyExistsException("The username already exists");
		}
		if (requiredMinimumCharactersUsername(username)){
			throw new RequiredMinimumCharacters("The username must be at least 3 characters long");
		}
		if (requiredMinimumCharactersPassword(password)) {
			throw new RequiredMinimumCharacters("The password must be at least 8 characters long");
		}
		User user = User.builder()
				.username(username)
				.password(passwordEncoder.encode(password))
				.createdAt(Instant.now())
				.build();
		User savedUser = accountRepository.save(user);
		return entityToDTO(savedUser);
	}
	private RegisterResponseDTO entityToDTO(User user){
		return RegisterResponseDTO.builder()
				.id(user.getId())
				.username(user.getUsername())
				.createdAt(user.getCreatedAt())
				.build();
	}
	@Transactional
	public LoginResponseDTO loginAccount(String username, String password){
		// check if the username exist in database
		if (!isUsernameExist(username)){
			throw new IllegalArgumentException("The username or password is incorrect!");
		}
		User userDB = accountRepository.findPasswordByUsername(username);
		boolean matchPassword = passwordEncoder.matches(password,userDB.getPassword());

		if (matchPassword){
			// get the username and last login timestamp in database
			LoginResponseDTO loginResponse = LoginResponseDTO.builder()
				.username(userDB.getUsername())
				.last_login_at(userDB.getLastLoginAt())
				.token(jwtService.generateToken(userDB.getUsername()))
				.build();
			// save the new login timestamp
			userDB.setLastLoginAt(Instant.now());
			accountRepository.save(userDB);
			return loginResponse;
		}
		// if ever blank password input
		throw new IllegalArgumentException("The username or password is incorrect!");
	}
	// NOT WORKING AT THE MOMENT (I WILL FIX THIS AFTER THE AUTHENTICATION WORK)
	public String deleteAccount(String username) {
		accountRepository.deleteByUsername(username);
		return "The account with the username '" + username + "'"+ " has been deleted";
	}
	public boolean isUsernameExist(String username) {
		return accountRepository.existsByUsername(username);
	}
	public boolean requiredMinimumCharactersUsername(String username){return username.length() < 5;}
	public boolean requiredMinimumCharactersPassword(String password){return password.length() < 8;}
	public boolean blankInputs(String username, String password) {
		return username == null || username.isBlank() ||
				password == null || password.isBlank();
	}
	// Response for GET endpoint if token still valid or not
	public TokenStatus tokenStatus(Authentication authentication){
		if (authentication == null){
		// parang magulo yung execute ko dto kapag no token entry dapat sa no authentication tlga to
		throw new NoTokenEntry("Unauthorized");
	}
		// 200 (OK) response if authentication is valid
		return  TokenStatus.builder()
				.timestamp(Instant.now())
				.status(HttpStatus.OK.value())
				.message("Token is working!")
				.error(null)
				.build();
	}
//	private boolean noToken(LoginResponseDTO token){
//		return (token.getToken() == null || token.getToken().isEmpty());
//	}
}
