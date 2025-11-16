package LMS;

public class Validator {
    public boolean Account(String name, int id){
        if (!name.equals("Mark") || id != 123){
            System.out.println("Please input the correct info!");
            return true;
        } else {
        	System.out.println("Login success!");
            return false;
        }
    }
}
