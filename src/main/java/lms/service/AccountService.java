package lms.service;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import lms.model.User;
import lms.dto.RegisterResponseDTO;
import lms.dto.LoginAccountDTO;
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
	public User loginAccount(String username, String password){
		User user = new User();
		if (accountRepository.findByUsernameAndPassword(username, password)){
			User hashedPassword = accountRepository.findPasswordByUsername(user.getUsername());

			passwordEncoder.matches(password, String.valueOf(hashedPassword));
			System.out.println("Success");
		}
		return user;
	}






	@Transactional
	// delete account method using the repository class with @Transactional (required)
	
	// 1. para sa admin muna yung ganitong role para ma practice yung authentication at authorization
	// 2. dapat required muna isulat yung username and password at "delete" na word para ma-delete tlga yung account
	// logic suggestion (kailangan muna yung username + old password to change into new password)
	public String deleteAccount(String username) {
		accountRepository.findByUsername(username);
		return "The account with the username '" + username + "'"+ " has been deleted";
	}
	
	// update account method using the repository class (findByID) with @Transactional (required)
	// FOR NOW: admin can only access this and can only do the updateAccount for security purposes
	// try ko dto yung AUTHORIZATION OR AUTHENTICATION
	@Transactional
//	public String updateAccount(int id, String username, String password) {
//		User user = accountRepository.findById(id)
//				.orElseThrow(() -> new RuntimeException("User not found"));
//		user.setUsername(username);
//		user.setPassword(password);
//		return "Successfully update the account!";
//	}
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
