package lms.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired; 

import lms.model.User;
import lms.repository.AccountRepository;

import jakarta.transaction.Transactional;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	// create account method with if-else to prevent empty inputs or duplicate username in database
	public String createAccount(String username, String password) {
		User user = new User();
		if (isBlankInputs(username, password)) {
			return "Username or password is invalid";
		} if (isUsernameExist(username)) {
			return "The username already exist";
		} else {
			user.setUsername(username);
			user.setPassword(password);
			accountRepository.save(user);
			return username;
		}
		
	}
	@Transactional
	// delete account method using the repository class with @Transactional (required)
	public String deleteAccount(String username, String password) {
		accountRepository.deleteByUsernameAndPassword(username, password);
		return username;
	}
	@Transactional
	// update account method using the repository class (findByID) with @Transactional (required)
	
	// FOR NOW: admin can only access this and can only do the updateAccount for security purposes
	// try ko dto yung AUTHORIZATION OR AUTHENTICATION
	public void udpateAccount(int id, String username, String password) {
		User user = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found"));
		user.setUsername(username);
		user.setPassword(password);
	}
	// The method used in createAccount method to make it short
	public boolean isBlankInputs(String username, String password) {
		if (username.isBlank() || password.isBlank()) {
			return true;
		} 
		return false;
	}
	
	public boolean isUsernameExist(String username) {
		if (accountRepository.existsByUsername(username)) {
			return true;
		}
		return false;
	}
	
}
