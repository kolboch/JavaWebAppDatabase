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

import utils.CookieUtils;
import utils.DatabaseUtils;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DeleteProductServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = CookieUtils.getStoredConnection(request);
		String code = request.getParameter("code");
		System.out.println("this is code passed by request: " + code);
		try {
			DatabaseUtils.deleteProduct(conn, code);
		} catch (SQLException e) {
			String errorString = "error occured when updating the delete.\n" + e.getMessage();
			request.setAttribute("errorMessage", errorString);
		}
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/productList");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
