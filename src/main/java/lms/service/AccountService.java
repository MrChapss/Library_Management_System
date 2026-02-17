package lms.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import lms.model.User;
import lms.repository.AccountRepository;

import jakarta.transaction.Transactional;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public User createAccount(String username, String password) {
		if (blankInputs(username, password)){
			throw new IllegalArgumentException("Username and password cannot be blank!");
		}
		if (isUsernameExist(username)){
			throw new UsernameAlreadyExistsException("Username already exists!");
		}
		User user = User.builder()
				.username(username)
				.password(passwordEncoder.encode(password))
				.build();
		return accountRepository.save(user);
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
	public static class UsernameAlreadyExistsException extends RuntimeException{
		public UsernameAlreadyExistsException(String message){
			super(message);
		}
	}

	public boolean isUsernameExist(String username) {
		return accountRepository.existsByUsername(username);
	}
	public boolean blankInputs(String username, String password) {
		if (username == null || username.isBlank()) {
			return true;
		} return (password == null || password.isBlank());
	}
}
