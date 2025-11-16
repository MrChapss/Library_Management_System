package LMS;

public class Student extends User {
    public void setStudentName(String name){
        this.name = name;
    }

    public void setStudentId(int id){
        this.Id = id;
    }

    public String getStudentName(){return name;}
    public int getStudentId(){return Id;}
}
