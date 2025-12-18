package lms;
import java.util.ArrayList;
import java.util.Scanner;

class Book {
	protected ArrayList<String> books = new ArrayList<String>();
	
	public void addingBook(Scanner input) {
		while (true) {
			System.out.print("Input the name of the book: ");
			String nameOfBook = input.nextLine();
			books.add(nameOfBook);
			books.remove("stop");
			
			if (nameOfBook.equals("stop")) {
			break;
			}
		}
	}
	// I'll finish this once I'm done doing the "add book" function
	public void isBookAvailable(Scanner input) {
		for (int i=0; i<books.size(); i++) {
			System.out.println(books.get(i));
		}
	}
	public void deletingBook(Scanner input) {
		while (true) {
			System.out.print("Input the name of the book to remove: ");
			String nameOfBook = input.nextLine();
			books.remove(nameOfBook);
			
			if (nameOfBook.equals("stop")) {
				break;
			}
		}
	}
}