package LMS;

public class Student extends Admin {
    public void setStudentName(String name){
        this.name = name;
    }

    public void setStudentId(int id){
        this.Id = id;
    }

    public String getStudentName(){return name;}
    public int getStudentId(){return Id;}
}
