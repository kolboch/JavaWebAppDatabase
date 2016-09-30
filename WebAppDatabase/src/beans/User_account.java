package beans;

public class User_account {
	private static final String GENDER_MALE = "M";
	private static final String GENDER_FEMALE = "F";
	
	private String user_name;
	private String password;
	private String gender;
	
	public User_account(){
		
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
