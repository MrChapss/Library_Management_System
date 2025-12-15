package lms;

public class User {
	protected String name;
    protected int Id;
    protected final int min = 0;
	protected int max = 3;
	protected int userChoice;
	
	public void userChoice(int userChoice) {
		this.userChoice = userChoice;
	}

    public void setName(String name){
        this.name = name;
        
        if (name.equals(null) || name.isBlank()) {
        	System.out.println(">> Name cannot be empty space or blank!");
        }
    }
    
    public void setId(int Id){
        this.Id = Id;
    }

    
    
    public boolean checkAcc(String name, int id){
    	
        if (!name.equals("user") || id != 123){
        	
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
    
    public boolean exiting(int userChoice) {
    	if (userChoice != 4) {
    		return true;
    	} else {
    		return false;
    	}
    	
    }
    
    public boolean menuChoice(int userChoice) {
    	while (true) {
    		switch (userChoice) {
				case 4 -> System.out.println("Exiting...");
	    	}
		    	return false;
	    	}
    }
}
