package lms.ui;

import java.util.Scanner;

public class ConsoleUI {
	private Scanner scanner = new Scanner(System.in);
	
	public void start() {
		System.out.println("=== LIBRARY ===");
		
		while(true) {
			System.out.print("Username: ");
			String userName = scanner.nextLine();
			
			System.out.print("Password: ");
			String password = scanner.nextLine();
			
			
		}
	}
}
