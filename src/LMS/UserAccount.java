package LMS;

public class UserAccount {
    private String name;
    private int studentId;
    private boolean isStudent;

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int id){
        this.studentId = id;
    }

    public void setStudent(boolean student){
        this.isStudent = student;
    }

    public String getName(){return name;}
    public int getStudentId(){return studentId;}
    public boolean getStudent(){return isStudent;}
}
