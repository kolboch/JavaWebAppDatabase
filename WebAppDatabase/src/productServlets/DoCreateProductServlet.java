package productServlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Product;
import utils.CookieUtils;
import utils.DatabaseUtils;

/**
 * Servlet implementation class DoCreateProductServlet
 */
@WebServlet(urlPatterns = {"/doCreateProduct"})
public class DoCreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public DoCreateProductServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	// by doPost create product will be called if will to change implement doGet method or other willing to serve that request
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = CookieUtils.getStoredConnection(request);
		
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		float priceNumber = 0;
		try{
			priceNumber = Float.parseFloat(price);
		}
		catch(NumberFormatException e){
		
		}
		
		Product product = new Product(code, name, priceNumber);
		String errorString = null;
		String regex = "\\w+";
		if(code == null || !code.matches(regex)){
			errorString = "Invalid code, must be at least one character!";
		}
		if(errorString == null){
			try {
				DatabaseUtils.insertProduct(conn, product);
			}
			catch (SQLException e) {
				errorString = "Error occured when updating product to database.\n" + e.getMessage();
			}
		}
		request.setAttribute("errorMessage", errorString);
		request.setAttribute("product", product); // in case input was invalid, user will see previous input
		
		if(errorString == null){
			response.sendRedirect(request.getContextPath() + "/productList"); // executes when no errors
		}
		else{ 
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/createProductView.jsp");
			dispatcher.forward(request, response);
		}
	}

}
