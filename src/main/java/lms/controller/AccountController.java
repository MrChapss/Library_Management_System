package lms.controller;
// MUST ADD DOCUMENTATIONS ON HOW THE IMPORTS WORK AND THE CONTROLLER ITSELF
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;

import lms.dto.CreateAccountRequest;
import lms.dto.ResponseRequest;
import lms.service.AccountService;

@RestController
@RequestMapping("/LMS/account")
public class AccountController {
	@Autowired
	private AccountService accountService;

	@PostMapping
	public ResponseEntity<ResponseRequest> createAccount(@Valid @RequestBody CreateAccountRequest register) {
		ResponseRequest response = accountService.createAccount(register.getUsername(), register.getPassword());
		 //accountService.createAccount(register.getUsername(), register.getPassword());
		 return ResponseEntity.ok(response);
	}
	@DeleteMapping
	public String deleteAccount(@RequestBody CreateAccountRequest user) {
		return accountService.deleteAccount(user.getUsername());
	}
}
//// working on it