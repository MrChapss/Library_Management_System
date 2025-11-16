package LMS;

public class User {
	protected String name;
    protected int Id;

    public void setName(String name){
        this.name = name;
    }

    public void setId(int Id){
        this.Id = Id;
    }

    public String getName(){return name;}
    public int getId(){return Id;}
}

