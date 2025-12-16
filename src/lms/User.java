package lms;

class User {
	protected int id;
	protected String userName;
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {return userName;}
	public int getId() {return id;}
	
	public boolean isAccountValid(String userName, int id) {
		System.out.println("Your account is not registered or member of LMS");
		return false;
	}
}