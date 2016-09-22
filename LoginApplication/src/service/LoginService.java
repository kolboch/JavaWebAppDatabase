package service;

public class LoginService {
	public boolean authenticate(String userName, char[]password){
		// here will normally go code connecting to database checking for existing user-password combination
		if(userName != null && userName.trim() != "" && password.length > 0){
			return true;
		}
		else{
			return false;
		}
	}
}
