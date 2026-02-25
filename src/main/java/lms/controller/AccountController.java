package lms.controller;
// MUST ADD DOCUMENTATIONS ON HOW THE IMPORTS WORK AND THE CONTROLLER ITSELF
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import jakarta.validation.Valid;

import lms.api.ApiResponse;
import lms.dto.RegisterAccountDTO;
import lms.dto.RegisterResponseDTO;
import lms.service.AccountService;

import java.time.Instant;

@RestController
@RequestMapping("/LMS")
public class AccountController {
	private final AccountService accountService;

	public AccountController(AccountService accountService){
		this.accountService=accountService;
	}
	@PostMapping("/register")
	public ResponseEntity<ApiResponse<RegisterResponseDTO>> createAccount(@Valid @RequestBody RegisterAccountDTO register) {
		RegisterResponseDTO accountData = accountService.createAccount(
				register.getUsername(),
				register.getPassword()
		);
		ApiResponse<RegisterResponseDTO> response = ApiResponse.<RegisterResponseDTO>builder()
				.timestamp(Instant.now())
				.status(HttpStatus.CREATED.value())
				.message("Account created successfully")
				.data(accountData)
				.error(null)
				.build();

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	@PostMapping("/login")
	public String loginAccount(@RequestParam String username,
							   @RequestParam String password){
		accountService.loginAccount(username,password);
		return "test";
	}

	@DeleteMapping
	public String deleteAccount(@RequestBody RegisterAccountDTO user) {
		return accountService.deleteAccount(user.getUsername());
	}
}
