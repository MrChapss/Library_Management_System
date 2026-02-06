package lms.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.beans.factory.annotation.Autowired;

import lms.dto.CreateAccountRequest;
import lms.service.AccountService;

@RestController
@RequestMapping("/LMS/account")
public class AccountController {
	
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping
	public String createAccount(@Valid @RequestBody CreateAccountRequest user) {
		return accountService.createAccount(user.getUsername(), user.getPassword());
	}
	
	@DeleteMapping
	public String deleteAccount(@RequestBody CreateAccountRequest user) {
		accountService.deleteAccount(user.getUsername(), user.getPassword());
		return "The account with the username '" + user.getUsername() + "'"+ " has been deleted";
	}
	
	@PutMapping
	public String updateAccount(@RequestBody CreateAccountRequest user) {
		accountService.udpateAccount(user.getId(), user.getUsername(), user.getPassword());
		return "Updated account";
	}
	
}
