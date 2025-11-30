package LMS;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		User function = new User();
		
		do {
			System.out.print("Enter a number: ");
			int num = Integer.parseInt(input.nextLine());
			
			
			System.out.println(function.oddOrEven(num));
		} while(function.getNum());
			
		
		
		
		
		
	}
}

