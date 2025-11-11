package LMS;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        // declare the class object
        UserAccount userData = new UserAccount();


        System.out.print("What is your name: ");
        userData.setName(input.nextLine());

        // result
        System.out.printf("Hello, my dearest %s!",userData.getName());
    }
}
