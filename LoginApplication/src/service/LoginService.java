package service;

import java.util.HashMap;

import dto.User;

public class LoginService {
	HashMap<String,String> users = new HashMap<String,String>();
	
	public LoginService(){
		users.put("johny bravo", "John Bravocosta");
		users.put("janbak", "Jan Bak");
		users.put("laivinto", "Leoni Vintoco");
	}
	
	public boolean authenticate(String userId, char[]password){
		// here will normally go code connecting to database checking for existing user-password combination
		if(userId != null && userId.trim() != "" && password.length > 0 && users.containsKey(userId)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public User getUserDetails(String userId){
		User user = new User();
		user.setUserName(users.get(userId));
		user.setUserId(userId);
		return user;
	}
}
