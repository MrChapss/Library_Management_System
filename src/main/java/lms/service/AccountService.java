package lms.service;

import lms.dto.LoginAccountDTO;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import lms.model.User;
import lms.dto.RegisterResponseDTO;
import lms.dto.LoginResponseDTO;
import lms.repository.AccountRepository;

import lms.exception.RequiredMinimumCharacters;
import lms.exception.UsernameAlreadyExistsException;
import lms.exception.IllegalArgumentException;

import jakarta.transaction.Transactional;

import java.time.Instant;

@Service
public class AccountService {
	private final AccountRepository accountRepository;
	private final PasswordEncoder passwordEncoder;

	public AccountService (AccountRepository accountRepository,
						   PasswordEncoder passwordEncoder){
		this.accountRepository=accountRepository;
		this.passwordEncoder=passwordEncoder;
	}
	public RegisterResponseDTO createAccount(String username, String password) {
		if (blankInputs(username, password)){
			throw new IllegalArgumentException("The username or password cannot be empty!");
		} if (isUsernameExist(username)){
			throw new UsernameAlreadyExistsException("The username already exists");
		}
		if (requiredMinimumCharactersUN(username)){
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
		User userDB = accountRepository.findPasswordByUsername(username);
		boolean matchPassword = passwordEncoder.matches(password,userDB.getPassword());
		if (matchPassword){
			// its working now
			userDB.setLastLoginAt(Instant.now());
			accountRepository.save(userDB);
			return response(userDB);
		}
		throw new IllegalArgumentException("Username or password is not correct!");
	}
	private LoginResponseDTO response(User user){
		return LoginResponseDTO.builder()
				.username(user.getUsername())
				.last_login_at(Instant.now())
				.build();
	}
	public String deleteAccount(String username) {
		accountRepository.existsByUsername(username);
		return "The account with the username '" + username + "'"+ " has been deleted";
	}
	public boolean isUsernameExist(String username) {
		return accountRepository.existsByUsername(username);
	}
	public boolean requiredMinimumCharactersUN(String username){return username.length() < 5;}
	public boolean requiredMinimumCharactersPassword(String password){return password.length() < 8;}
	public boolean blankInputs(String username, String password) {
		return username == null || username.isBlank() ||
				password == null || password.isBlank();
	}
}
