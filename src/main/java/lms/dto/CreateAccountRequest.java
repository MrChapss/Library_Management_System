package lms.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAccountRequest {
	private int id;
	@NotBlank(message="Username must not be empty")
	private String username;
	@NotBlank(message="Password must not be empty" )
	private String password;
	// KAILANGAN INTIDIHIN KO PURPOSE NITONG PACKAGE NA 'TO
	// MAG KAKAIBA PURPOSE PALA NITO HINDI SIYA "ONE FOR ALL"
}
