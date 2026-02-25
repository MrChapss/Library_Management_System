package lms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// ano itong import na to referring to line 6
// ano itong import na to referrring to line 8
import org.springframework.web.bind.annotation.ExceptionHandler;
// ano kaya pinagkaiba ng rest controller vs rest controller advice
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lms.api.ApiResponse;

import java.time.Instant;
//import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UsernameAlreadyExistsException.class)
    public ResponseEntity<ApiResponse<Void>> handleUsernameExists(
            UsernameAlreadyExistsException ex){
        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .timestamp(Instant.now())
                .status(HttpStatus.CONFLICT.value())
                .message("Account creation failed")
                .data(null)
                .error(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<Void>> handleIllegalArgument(
            IllegalArgumentException ex) {
        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .timestamp(Instant.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .message("Invalid input")
                .data(null)
                .error(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    @ExceptionHandler(RequiredMinimumCharacters.class)
    public ResponseEntity<ApiResponse<Void>> handleMinimumCharacters(
            RequiredMinimumCharacters ex) {
        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .timestamp(Instant.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .message("Validation failed")
                .error(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}
