package lms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterAccountDTO {
	@NotBlank(message="Username is required!")
	@Size(min=3, max=20, message="Username must be between 3 and 20 characters")
	private String username;

	@NotBlank(message="Password is required!" )
	@Size(min=8, message="Password must be at least 8 characters")
	private String password;

	// KAILANGAN INTIDIHIN KO PURPOSE NITONG PACKAGE NA 'TO
	// MAG KAKAIBA PURPOSE PALA NITO HINDI SIYA "ONE FOR ALL"
}
