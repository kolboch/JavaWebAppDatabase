package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User_account;

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
			
		}
	}

}
