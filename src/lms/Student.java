package lms;

class Student extends User{
	@Override
	public boolean isAccountValid(String userName, int id) {
		if (userName.equals("Mark") && id == 123 ) {
			return false;
		} else {
			return true;
		}
	}
}
