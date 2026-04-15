package lms.controller;
// MUST ADD DOCUMENTATIONS ON HOW THE IMPORTS WORK AND THE CONTROLLER ITSELF
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import jakarta.validation.Valid;

import lms.dto.TokenStatus;
import lms.api.ApiResponse;
import lms.dto.RegisterAccountDTO;
import lms.dto.RegisterResponseDTO;
import lms.dto.LoginAccountDTO;
import lms.dto.LoginResponseDTO;
import lms.service.AccountService;
import org.springframework.web.client.RestClient;

import java.time.Instant;

@RestController
@RequestMapping("/LMS")
public class AccountController {
	private final AccountService accountService;
	private final RestClient.Builder builder;

	public AccountController(AccountService accountService, RestClient.Builder builder){
		this.accountService=accountService;
		this.builder = builder;
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
	public ResponseEntity<ApiResponse<LoginResponseDTO>> loginAccount(@RequestBody LoginAccountDTO login){
		LoginResponseDTO loginData = accountService.loginAccount(
				login.getUsername(),
				login.getPassword()
		);
		ApiResponse<LoginResponseDTO> loginResponse = ApiResponse.<LoginResponseDTO>builder()
				.timestamp(Instant.now())
				.status(HttpStatus.OK.value())
				.message("Login successfully")
				.data(loginData)
				.build();
		return ResponseEntity.status(HttpStatus.OK).body(loginResponse);

	}
	// Use raw JSON and type the username to delete a user in the database (ERROR "NOT WORKING AT THE MOMENT")
	@DeleteMapping("/delete")
	public String deleteAccount(@RequestBody RegisterAccountDTO user) {
		return accountService.deleteAccount(user.getUsername());
	}

	@GetMapping("/me")
	public TokenStatus tokenChecking(Authentication authentication){
		return accountService.tokenStatus(authentication);
	}

//	@GetMapping("/me")
//	public String testGetEndpoint(Authentication test){
//		if (test == null){
//			return "Error authentication";
//		} else {
//			return test.getName();
//		}
//	}


}


