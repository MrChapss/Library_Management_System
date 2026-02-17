package lms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

// @Builder annotation - To simplify creation of builder pattern (in short, reduce boilerplate code)
import lombok.Builder;
// @Setter annotation - setter method (in short, reduce boilerplate code)
import lombok.Setter;
// @Getter annotation - getter method (in short, reduce boilerplate code)
import lombok.Getter;
// @NoArgsConstructor - For hibernate to create empty constructor
import lombok.NoArgsConstructor;
// @AllArgsConstructor - For user to create a book immediately if all fields are complete
import lombok.AllArgsConstructor;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
// this class act as a table structure in database
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//Automatic false siguro muna 'to para si 1st Admin na mag bibigay ng access kay other or next admins
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private boolean isAdmin = false;
}
