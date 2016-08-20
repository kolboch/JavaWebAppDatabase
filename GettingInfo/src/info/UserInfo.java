package info;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserInfo
 */
public class UserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Date now = new Date();
		out.println("<html><head>");
		out.println("<link rel='stylesheet' type='text/css' href='./css/style.css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("Time: " + now.toString());
		out.println("<br>");
		out.println("This is userInfo:<br>");
		out.println("<p id='redText'>Request protocol: " + request.getProtocol() + "</p>");
		out.println("<p id='greyText'>Request portName: " + request.getLocalPort() + "</p>");
		out.println("<p id='greenText'>Request URI: " + request.getRequestURI() + "</p>");
		out.println("<p id='blueText'>Request remoteHost: " + request.getRemoteHost() + "</p>");
		out.println("<p id='greenText'>Request URL: " + request.getRequestURL() + "</p>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
