package authorQuery;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QueryServlet
 */
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//get a output writer to write the response message into the network socket
		PrintWriter out = response.getWriter();
		
		Connection conn = null;
		Statement stmt = null;
		String user = "myUser";
		String password = "clientpass";
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop?useSSL=false", user, password);
			stmt = conn.createStatement();
			String[] authorsSelect = request.getParameterValues("author[]");
			String ORauthors = build_OR_String(authorsSelect, "author");
			String selectQuery = "select title, author, price from books where " + ORauthors
					+ "AND quantity > 0 ORDER BY price DESC";
			//printing query result as HTML using PrintWriter
			out.println("<html><head><title>Query response</title></head><body>");
			out.println("<h2>Thank you for your query!</h2>");
			out.println("<p>Your query is: "+ selectQuery +"</p>");
			
			ResultSet rsltSet = stmt.executeQuery(selectQuery);
			//result variables initialization
			String title; String author; float price;
			int count = 0;
			while(rsltSet.next()){
				title = rsltSet.getString(1);
				author = rsltSet.getString(2);
				price = rsltSet.getFloat(3);
				out.println("<p>title: " + title + " author: " + author + " price($): " + price + "</p>");
				count++;
			}
			out.println("<p>========== " + count +" records found ==========</p>");
			out.println("</body></html>");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(conn != null){
					conn.close();
				}
				if(stmt != null){
					stmt.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	private String build_OR_String(String[]args, String columnName){
		StringBuilder sb = new StringBuilder(columnName + "= ");
		for(int i = 0; i < args.length; i++){
			sb.append("'" + args[i] + "'");
			if(i + 1 < args.length){
				sb.append(" OR " + columnName + "= ");
			}
		}
		return sb.toString();
	}

}
