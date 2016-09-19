package SessionTest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest
 */
@WebServlet(urlPatterns = "/SessionTest",
	initParams = {
			@WebInitParam(name="firstName", value="John"),
			@WebInitParam(name="secondName", value="Kowalski"),
			@WebInitParam(name="profession", value="non defined ;(")
	}
)
public class SessionTest extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		
		String fstName = request.getParameter("firstName");
		if(fstName != null && fstName.trim() != ""){
			session.setAttribute("firstName", fstName);
		}
		else{
			fstName = (String)session.getAttribute("firstName");
			if(fstName == null){
				fstName = this.getServletConfig().getInitParameter("firstName");
			}
		}
		
		String secondName = request.getParameter("secondName");
		if(secondName != null && secondName.trim() != ""){
			session.setAttribute("secondName", secondName);
		}
		else{
			secondName = (String)session.getAttribute("secondName");
			if(secondName == null){
				secondName = this.getServletConfig().getInitParameter("secondName");
			}
		}
		
		String profession = request.getParameter("profession");
		if(profession != null && profession.trim() != ""){
			session.setAttribute("profession", profession);
		}
		else{
			profession = (String)session.getAttribute("profession");
			if(profession == null){
				profession = this.getServletConfig().getInitParameter("profession");
			}
		}
		out.println("<html><head><title>Session test response.</title></head><body>");
		out.println("Hello " + fstName + " " + secondName + "!<br/>");
		out.println("Your profession is: " + profession + ".");
		out.println("</body></html>");
	}

}
