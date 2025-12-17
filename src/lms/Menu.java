package lms;
import java.util.Scanner;

public class Menu {
	public void Skibidi(Scanner input, User data) {
		data.Message();
		System.out.printf("%nInput here: ");
		int userInput = Integer.parseInt(input.nextLine());
		
		System.out.println(userInput);
		
	}
}
