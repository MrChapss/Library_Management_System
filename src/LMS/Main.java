package LMS;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        // declare the class object
        Admin adminData = new Admin();
        Student studentData = new Student();
        Book bookData = new Book();
        Validator checkAcc = new Validator();

        //input
        do {
            // ERROR - nag s-skip na naman sa scanner tuwing nag l-loop (medyo fixed)
            // gagamitan ko ng parse line (if maganda siya gamitin)
            System.out.print("Please enter your id: ");
            int userID = input.nextInt();
            input.nextLine();
            studentData.setStudentId(userID);

            System.out.print("Please enter your name: ");
            String userName = input.nextLine();
            studentData.setStudentName(userName);

            /*
                Name and ID must be match!
                Ex. Name: Sigma
                    ID: 123
                    Success!

             */

        } while(checkAcc.Account(studentData.getStudentName(), studentData.getStudentId()));



        //output
        //System.out.println("Hello! " + studentData.getStudentName());
        //System.out.println("Hello! " + studentData.getStudentId());
        
        //FUCK THE SCHEDULE BRO
        //FUCK ALL PEOPLE
        //FUCK THEM!!!
        //I WANT TO FUCKING CODE FR
    }
}
