package controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.User;
import service.LoginService;

/**
 * Servlet implementation class Authentication
 */
@WebServlet(description = "Servlet authenticating typed login and poassword.", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userName");
		char[] password = request.getParameter("password").toCharArray();
		LoginService auth = new LoginService();
		boolean correctPass = auth.authenticate(userId, password);
		
		if(correctPass){
			User user = auth.getUserDetails(userId);
			request.setAttribute("user", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("loggedIn.jsp");
			dispatcher.forward(request, response);
			return;
		}
		else{
			response.sendRedirect("login.jsp");
		}
	}

}
