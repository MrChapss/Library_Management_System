package lms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
// the book class is responsible for CRUD functions on the menu
// i might remove this class (nah)

// paano ko to gagawing generalize (ito agenda ko bukas)
class bookService {
	protected ArrayList<String> books = new ArrayList<String>();
	
	public void addingBook(Scanner input) {
		System.out.printf("%nTip: input '4' to stop adding");
		while (true) {
			System.out.print("Input the name of the book: ");
			String nameOfBook = input.nextLine();
			books.add(nameOfBook);
			
			if (nameOfBook.isBlank()) {
				books.remove(nameOfBook);
			}
			books.remove("4"); 
			if (nameOfBook.equals("4")) {
			break;
			}
			// add ako if na ang purpose ay no repetead same book "the book already exist"
		}
	}
	public void isBookAvailable(Scanner input) {
		for (int i=0; i<books.size(); i++) {
			Collections.sort(books);
			System.out.println(books.get(i));
		}
		if (books.isEmpty()) {
			System.out.printf("%nThere are no books availabale at the moment!%n");
		}
	}
	public void deletingBook(Scanner input) {
		System.out.printf("%nTip: input '4' to stop deleting");
		while (true) {
			System.out.print("Input the name of the book to remove: ");
			String nameOfBook = input.nextLine();
			books.remove(nameOfBook);
			if (nameOfBook.equals("4")) {
				break;
			}
			// add ako if na ang purpose ay "the book does not exist"
		}
	}
}