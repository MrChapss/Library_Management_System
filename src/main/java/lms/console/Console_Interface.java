package lms.console;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lms.model.Account;

import java.util.Scanner;

@Component
public class Console_Interface implements CommandLineRunner{
	
	private final Account user;
	
	public Console_Interface(Account user) {
		this.user=user;
	}

	@Override
	public void run(String... args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to Library Management System");
		while(true) {
			System.out.printf("%n%nAvailable options:");
			System.out.println("1. Login");
			System.out.println("2. Sign up");
			System.out.println("3. Exit");
			System.out.printf("%n%nEnter your choice: ");
			int choice = Integer.parseInt(sc.nextLine());
			
			switch(choice) {
				case 2 -> {
					System.out.print("Enter username: ");
					String username = sc.nextLine();
					user.setUsername(username);
					System.out.print("Enter password");
					String password = sc.nextLine();
					user.setPassword(password);
					
				}
			}
		}
		
	}
}

// IM NOT SURE ABOUT THIS CONSOLE INTERFACE SINCE IM CONFUSED ASF HOW TO EXECUTE IT
