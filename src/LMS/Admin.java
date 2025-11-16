package LMS;

public class Admin extends User {
    public void setAdminName(String name){
        this.name = name;
    }

    public void setAdminId(int Id){
        this.Id = Id;
    }

    public String getAdminName(){return name;}
    public int getAdminId(){return Id;}
}

