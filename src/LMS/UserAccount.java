package LMS;

public class UserAccount {
    private String name;
    private int age;
    private boolean student;

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setStudent(boolean student){
        this.student = student;
    }

    public String getName(){return name;}
    public int getAge(){return age;}
    public boolean getStudent(){return student;}
}
