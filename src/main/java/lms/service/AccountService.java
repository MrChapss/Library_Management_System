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
	// the logic when creating an account (setting the username and password)
	public void createAccount(String username, String password) {
		User user = new User();
		if (checkAccount(username, password)) {
			return;
		} else {
			user.setUsername(username);
			user.setPassword(password);
		}
		accountRepository.save(user);
	}
	@Transactional
	public void deleteAccount(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		accountRepository.deleteByUsernameAndPassword(username, password);
	}
	@Transactional
	public void udpateAccount(int id, String username, String password) {
		User user = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found"));
		user.setUsername(username);
		user.setPassword(password);
	}
	public boolean checkAccount(String username, String password) {
		if (username.isBlank() || password.isBlank() || accountRepository.existsByUsername(username)) {
			return true;
		}
		return false;
	}
	
}
