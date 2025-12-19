package lms;

class User {
	protected String passWord;
	protected String userName;
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassWord(String id) {
		this.passWord = id;
	}
	public String getUserName() {return userName;}
	public String getPassWord() {return passWord;}
	
	public boolean isAccountValid(String userName, String passWord) {
		System.out.println("Your account is not registered or member of LMS");
		return false;
	}
	
	// i-polymorphism ko siya sa student and librarian (admin)
	public void Message() {
		System.out.println("Welcome users!");
	}
}