package productServlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Product;
import beans.User_account;
import utils.CookieUtils;
import utils.DatabaseUtils;

/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet(urlPatterns = {"/productList"})
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ProductListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String errorString = null;
		User_account user = CookieUtils.getStoredLoginedUser(request.getSession());
		
		if(user == null){
			errorString = "You must be logged in to query product.";
			request.setAttribute("errorMessage", errorString);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login");
			dispatcher.forward(request, response);
		}
		Connection conn = CookieUtils.getStoredConnection(request);
		
		List<Product>products = null;
		
		try {
			products = DatabaseUtils.queryProduct(conn);
		}
		catch (SQLException e) {
			errorString = "Error occured when trying to query product.\n" + e.getMessage();
			e.printStackTrace();
		}
		
		request.setAttribute("errorMessage", errorString);
		request.setAttribute("productList", products); 
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/productListView.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
