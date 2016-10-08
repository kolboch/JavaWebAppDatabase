package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.CookieUtils;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String viewRedirectPath = "/WEB-INF/views/loginPage.jsp";
	private static final String alreadyLogedRedirectPath = "/userInfo";
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		redirectToView(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		redirectToView(req, resp);
	}
	
	private void redirectToView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		RequestDispatcher dispatcher;
		if(CookieUtils.getStoredLoginedUser(req.getSession()) != null){
			dispatcher = this.getServletContext().getRequestDispatcher(alreadyLogedRedirectPath);
		}
		else{
			dispatcher = this.getServletContext().getRequestDispatcher(viewRedirectPath);
		}
		dispatcher.forward(req, resp);
	}

}
