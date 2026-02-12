package lms.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

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
	public ResponseEntity<CreateAccountRequest> createAccount(@Valid @RequestBody CreateAccountRequest user) {
		//return accountService.createAccount(user.getUsername(), user.getPassword());
		accountService.createAccount(user.getUsername(), user.getPassword());
		return ResponseEntity.ok(user);
	}
	@DeleteMapping
	public String deleteAccount(@RequestBody CreateAccountRequest user) {
		return accountService.deleteAccount(user.getUsername());
	}
	@PutMapping
	public String updateAccount(@RequestBody CreateAccountRequest user) {
		return accountService.updateAccount(user.getId(), user.getUsername(), user.getPassword());
	}
	// HINDI DAW DPAT STRING YUNG RETURN NG METHOD SA CONTROLLER
}
