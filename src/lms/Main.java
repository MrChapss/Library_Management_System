package lms;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Login login = new Login();
		Student studentAccountData = new Student ();
		Admin adminAccountData = new Admin();
		
		System.out.printf("Welcome to LMS!%n%n");
		System.out.println("Please choose an account:");
		System.out.println("1. Student");
		System.out.println("2. Admin");
		System.out.printf("%nInput here: ");
		int choosingAccount = Integer.parseInt(input.nextLine());
		
		switch(choosingAccount) {
			case 1 -> {
				// call the method for student login
				login.isLogginIn(input, studentAccountData);
			}
			case 2 -> {
				// call the method for admin login
				login.isLogginIn(input, adminAccountData);
			}
		}
	}
}