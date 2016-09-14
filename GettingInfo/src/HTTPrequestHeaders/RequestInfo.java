package HTTPrequestHeaders;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestInfo
 */
@WebServlet(description = "Servlet getting request headers values.", urlPatterns = { "/RequestInfo" })
public class RequestInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>\n<head>");
		out.println("<link rel='stylesheet' type='text/css' href='./css/requestHeadersStyle.css'>");
		out.println("<title>Request parameter values.</title>\n");
		out.println("</head>\n<body>\n");
		out.println("<h2 style='text-align:center;'>Request parameters</h2>");
		out.println("Request method: " + request.getMethod() + "<br/>");
		out.println("Request protocol: " + request.getProtocol() + "<br/>");
		out.println("Request URI: " + request.getRequestURI() + "<br/>" + "<br/>");
		
		Enumeration<String>headers = request.getHeaderNames();
		out.println("<table>\n");
		out.println("<tr><th>header name<th>header value</tr>");
		String headerName;
		while(headers.hasMoreElements()){
			headerName = headers.nextElement();
			out.println("<tr><td>"+ headerName + "</td><td>" + request.getHeader(headerName) + "</td></tr>");
		}
		out.println("</table>");
		out.println("</body>\n</html>");
	}
}
