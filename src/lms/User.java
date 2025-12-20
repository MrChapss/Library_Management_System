package lms;
// User is the parent class or super class
class User {
	// I'm finding a way to enhance the security of password and username
	protected String passWord;
	protected String userName;
	// stored the username
	public void setUserName(String userName) {
		this.userName = userName;
	}	
	// stored the username
	public void setPassWord(String id) {
		this.passWord = id;
	}
	// pass the stored value
	public String getUserName() {return userName;}
	public String getPassWord() {return passWord;}
	// used for account validation if user inputs are correct
	public boolean isAccountValid(String userName, String passWord) {
		System.out.println("Your account is not registered or member of LMS");
		return false;
	}
	// used for user instruction for the menu
	public void menuInstruction() {
		System.out.println("Welcome users!");
	}
}