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
		User user = User.builder();
				.username(username)
				.password(password)
				.build();
		accountRepository.save(user);
	}
	
	
	// create account method with if-else to prevent empty inputs or duplicate username in database
//	public User createAccount(String username, String password) {
//		User user = new User();
//			if (user.blankInputs(username, password)) {
//				return user;
//			} if (isUsernameExist(username)) {
//				return user;
//			} else {
//				user.setUsername(username);
//				user.setPassword(passwordEncoder.encode(password));
//				return accountRepository.save(user);
//			}
//	}
	
	
	@Transactional
	// delete account method using the repository class with @Transactional (required)
	
	// 1. para sa admin muna yung ganitong role para ma practice yung authentication at authorization
	// 2. dapat required muna isulat yung username and password at "delete" na word para ma-delete tlga yung account
	// logic suggestion
	public String deleteAccount(String username) {
		accountRepository.findByUsername(username);
		return "The account with the username '" + username + "'"+ " has been deleted";
	}
	@Transactional
	// update account method using the repository class (findByID) with @Transactional (required)
	
	// FOR NOW: admin can only access this and can only do the updateAccount for security purposes
	// try ko dto yung AUTHORIZATION OR AUTHENTICATION
	public String updateAccount(int id, String username, String password) {
		User user = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found"));
		user.setUsername(username);
		user.setPassword(password);
		return "Successfully update the account!";
	}
	public boolean isUsernameExist(String username) {
		if (accountRepository.existsByUsername(username)) {
			return true;
		}
		return false;
	}
}
