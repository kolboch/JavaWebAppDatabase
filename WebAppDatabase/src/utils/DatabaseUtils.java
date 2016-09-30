package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.User_account;

public class DatabaseUtils {
	public static User_account findUser(Connection conn, String userName, String password) throws SQLException{
		String sql = "SELECT a.user_name, a.password, a.gender FROM user_account a"
				+ " WHERE a.user_name = ? and a.password = ?";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, userName);
		prepStmt.setString(2, password);
		ResultSet rs = prepStmt.executeQuery();	
		
		if(rs.next()){
			String gender = rs.getString("gender");
			User_account user = new User_account();
			user.setUser_name(userName);
			user.setPassword(password);
			user.setGender(gender);
			return user;
		}
		return null;
	}
	
	public static User_account findUser(Connection conn, String userName) throws SQLException{
		String sql = "SELECT a.user_name, a.password, a.gender FROM user_account a"
				+ " WHERE a.user_name = ?";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1,  userName);
		ResultSet rs = prepStmt.executeQuery();
		if(rs.next()){
			String gender = rs.getString("gender");
			String password = rs.getString("password");
			User_account u = new User_account();
			u.setGender(gender);
			u.setPassword(password);
			u.setUser_name(userName);
			return u;
		}
		return null;
	}
}
