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
	
	// create account method with if-else to prevent empty inputs or duplicate username in database
	public String createAccount(String username, String password) {
		User user = new User();
		user.setUsername("nigga123");
		user.setPassword("wowthatsnigga");
		passwordEncoder.encode(user.getPassword());
		accountRepository.save(user);
		return "test";
		/*
			if (user.blankInputs(username, password)) {
				return "Username or password is invalid";
			} if (isUsernameExist(username)) {
				return "The username already exist";
			} else {
				user.setUsername(username);
				passwordEncoder.encode(user.getPassword());
				accountRepository.save(user);
				return "Welcome to LMS, " + username + "!";
			}
		*/
	}
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
