package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User_account;
import utils.CookieUtils;
import utils.DatabaseUtils;

@WebServlet(urlPatterns = "/doLogin")
public class DoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DoLoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		User_account user = null;
		String errorMessage = null;
		boolean invalid = false;
		
		if(login == null || password == null || login.trim().length() == 0 || password.trim().length() == 0){
			invalid = true;
			errorMessage = "No login or password passed in.";
		}
		else{
			Connection conn = CookieUtils.getStoredConnection(request);
			try {
				user = DatabaseUtils.findUser(conn, login, password);
				if(user == null){
					errorMessage = "Invalid user name or password.";
					invalid = true;
				}
			}
			catch (SQLException e){
				e.printStackTrace();
			}
		}
		// here we got user or invalid input
		if(invalid){
			user = new User_account();
			user.setUser_name(login);
			user.setPassword(password);
			
			request.setAttribute("user", user);
			request.setAttribute("errorMessage", errorMessage);
			
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginPage.jsp");
			dispatcher.forward(request, response);
		}
		else{
			HttpSession session = request.getSession();
			CookieUtils.storeLoginedUser(session, user);
			response.sendRedirect(request.getContextPath() + "/userInfo");
		}
	}

}
