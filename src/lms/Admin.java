package lms;

class Admin extends User {
	@Override
	public boolean isAccountValid(String userName, int id) {
		if (userName.equals("Admin") && id == 123) {
			return false;
		} else {
			return true;
		}
	}
}