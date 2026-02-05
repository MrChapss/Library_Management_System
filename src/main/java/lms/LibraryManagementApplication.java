package lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryManagementApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApplication.class, args);
	}
	

}

// BUKAS MAG JPA NA TAYO AND REMOVE NA YUNG JDBC DATABASE
// REFACTOR YUNG CODE VERSION (02/01/26) BUKAS