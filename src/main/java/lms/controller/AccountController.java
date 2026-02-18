package lms.controller;
// MUST ADD DOCUMENTATIONS ON HOW THE IMPORTS WORK AND THE CONTROLLER ITSELF
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import jakarta.validation.Valid;

import lms.dto.CreateAccountRequest;
import lms.dto.ResponseRequest;
import lms.service.AccountService;

@RestController
@RequestMapping("/LMS/account")
public class AccountController {
	private final AccountService accountService;

	public AccountController(AccountService accountService){
		this.accountService=accountService;
	}
	@PostMapping
	public ResponseEntity<ResponseRequest> createAccount(@Valid @RequestBody CreateAccountRequest register) {
		ResponseRequest response = accountService.createAccount(
				register.getUsername(),
				register.getPassword());
		 return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	@DeleteMapping
	public String deleteAccount(@RequestBody CreateAccountRequest user) {
		return accountService.deleteAccount(user.getUsername());
	}
}
//// working on it