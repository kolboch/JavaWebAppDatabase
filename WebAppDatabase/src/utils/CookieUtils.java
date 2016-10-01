package utils;

import java.sql.Connection;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User_account;

public class CookieUtils {
	public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
	private static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME";
	
	/**
	 * stores connection in request attribute, information stored exists only during requests
	 * @param request
	 * @param conn
	 */
	public static void storeConnection(ServletRequest request, Connection conn){
		request.setAttribute(ATT_NAME_CONNECTION, conn);
	}
	/**
	 * retrieves connection stored in request
	 * @param request
	 * @return
	 */
	public static Connection getStoredConnection(ServletRequest request){
		Connection con = (Connection)request.getAttribute(ATT_NAME_CONNECTION);
		return con;
	}
	/**
	 * store user info in session
	 * @param session
	 * @param user
	 */
	public static void storeLoginedUser(HttpSession session, User_account loginedUser){
		session.setAttribute("loginedUser", loginedUser);
	}
	/**
	 * retrieves user information stored in session
	 * @param session
	 * @return
	 */
	public static User_account getStoredLoginedUser(HttpSession session){
		User_account loginedUser = (User_account)session.getAttribute("loginedUser");
		return loginedUser;
	}
	/**
	 * stores information in cookie
	 * @param response
	 * @param user
	 */
	public static void storeUserCookie(HttpServletResponse response, User_account user){
		System.out.println("Store user cookie");
		Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, user.getUser_name());
		
		cookieUserName.setMaxAge(60*60*24); // will expire after one 24 hours
		response.addCookie(cookieUserName);
	}
	/**
	 * retrieves user name from cookie, if not founded, would return null
	 * @param request
	 * @return
	 */
	public static String getUserNameFromCookie(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(int i = 0; i < cookies.length; i++){
				if(cookies[i].getName().equals(ATT_NAME_USER_NAME)){
					return cookies[i].getValue();
				}
			}
		}
		return null;
	}
	/**
	 * deletes stored user cookie
	 * @param response
	 */
	public static void deleteUserCookie(HttpServletResponse response){
		Cookie deleteUserCookie = new Cookie(ATT_NAME_USER_NAME, null);
		deleteUserCookie.setMaxAge(0);
		response.addCookie(deleteUserCookie);
	}
}
