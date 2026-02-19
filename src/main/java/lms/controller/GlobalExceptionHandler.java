package lms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// ano itong import na to referring to line 6
import org.springframework.web.bind.MethodArgumentNotValidException;
// ano itong import na to referrring to line 8
import org.springframework.web.bind.annotation.ExceptionHandler;
// ano kaya pinagkaiba ng rest controller vs rest controller advice
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lms.api.ApiResponse;
import lms.service.AccountService;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    //@ExceptionHandler(AccountService.UsernameAlreadyExistsException.class)
    public ResponseEntity<ApiResponse<Void>> handleUsernameExists(
            AccountService.UsernameAlreadyExistsException ex){
        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .timestamp(Instant.now())
                .status(HttpStatus.CONFLICT.value())
                .message("Account creation failed")
                .data(null)
                .errors(List.of(ex.getMessage()))
                .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
}
