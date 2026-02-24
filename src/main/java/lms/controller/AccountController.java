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

import lms.api.ApiResponse;
import lms.dto.RegisterAccountDTO;
import lms.dto.RegisterResponseDTO;
import lms.service.AccountService;
import lms.exception.GlobalExceptionHandler;

import java.time.Instant;

@RestController
@RequestMapping("/LMS/account")
public class AccountController {
	private final AccountService accountService;
	private final GlobalExceptionHandler globalExceptionHandler;

	public AccountController(AccountService accountService,
							 GlobalExceptionHandler globalExceptionHandler){
		this.accountService=accountService;
		this.globalExceptionHandler=globalExceptionHandler;
	}

	@PostMapping
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
				.errors(null)
				.build();

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	@DeleteMapping
	public String deleteAccount(@RequestBody RegisterAccountDTO user) {
		return accountService.deleteAccount(user.getUsername());
	}
}
