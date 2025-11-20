package LMS;

public class Student extends User {

    public String getName(){return name;}
    public int getId(){return Id;}
    
    @Override
    public boolean checkAcc(String name, int id){
    	
        if (!name.equals("Mark Lamadora") || id != 123){
        	
            System.out.printf(">>Your ID or Name is incorrect!%n");
            
            if (max > min) {
            System.out.printf(">>You only have %d chance/s left%n",max);
            }
            
            if (max == min) {
            	System.out.printf("%n>>You have reached the maxium retries! Try again later.");
            	return false;
            }
            max--;
            return true;
        } else {
        	System.out.println("Login success!");
        	return false;
        }
    }
    
}
