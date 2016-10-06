package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User_account;
import utils.CookieUtils;

@WebServlet(urlPatterns = {"/userInfo"})
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		checkUserAndRedirect(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		checkUserAndRedirect(request,response);
	}
	
	private void checkUserAndRedirect(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		User_account user = CookieUtils.getStoredLoginedUser(session);
		if(user == null){
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/userInfo.jsp");
		dispatcher.forward(request, response);
	}
}
