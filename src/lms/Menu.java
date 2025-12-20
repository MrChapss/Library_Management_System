package lms;
import java.util.Scanner;

public class Menu {
	bookService books = new bookService();
	
	public void menu(Scanner input, User data) {
		while(true) {
			data.menuInstruction();
			System.out.printf("%nInput here: ");
			int userInput = Integer.parseInt(input.nextLine());
			
			if (userInput == 4) {
				System.out.printf("%nExiting...");
				break;
			}
			switch (userInput) {
				case 1 -> books.addingBook(input);
				case 2 -> books.deletingBook(input);
				case 3 -> books.isBookAvailable(input);
			}
		}
	}
	// naiisip ko gumawa ng isa pang method kasi different dpat yung function e
}
