package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Hello extends HttpServlet {

	private static final long serialVersionUID = 1570533579329809755L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//write the response message in HTML page
		try{
			out.println("<html>");
			out.println("<head><title>Hello World!</title>");
			out.println("</head><body>");
			out.println("<h1>Hi, welcome to our webpage.</h1>");
			// echo clien't request information
			out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
			out.println("<p>Protocol: " + request.getProtocol() + "</p>");
			out.println("<p>PathInfo: " + request.getPathInfo() + "</p>");
			out.println("<p>RemoteAdress: " + request.getRemoteAddr() + "</p>");
			//generate random number upon each request
			out.println("Random number: <strong>" + Math.random() + "</strong></p>");
			out.println("</body></html>");
		}
		finally{
			out.close(); // always close the output writer
		}
		
	}
}
