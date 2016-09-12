package cvGenerator;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResumeGenerator
 */
@WebServlet(description = "Generates resume based on user preferences send over html request", urlPatterns = { "/generateResume" })
public class ResumeGenerator extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ResumeGenerator() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String docType = "<!DOCTYPE html>";
		out.println(docType);
		out.println("<html><head>");
		out.println("<title>CV GEN</title>");
		out.println("</head>");
		int fontSize = Integer.parseInt(replaceIfMissingOrDefault(request.getParameter("fontSize"), "14"));
		String fontColor = request.getParameter("fontColor");
		fontColor = replaceIfMissingOrDefault(fontColor, "black");
		String languages = replaceIfMissingOrDefault(request.getParameter("lang"), "none");
		out.println("<body style='font-size:" + fontSize +"px; color: "+ fontColor +";'>");
		out.println("<p style='text-align:center; font-size: 35px; color:black;'>RESUME</p><hr>");
		out.println("<p style='font-size: 25px; color:black;'>Languages I CAN: </p>");
		out.println(printLanguages(languages));
		out.println("This text should has different color or size");
		out.println("</body></html>");
		
	}
	private String printLanguages(String languagesInput){
		StringBuilder builder = new StringBuilder("<ul>");
		String regex ="(.*)[\n|\r]?";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(languagesInput);
		while(m.find()){
				System.out.println(m.group());
				builder.append("<li>" + m.group() + "</li>");
		}
		builder.append("</ul>");
		return builder.toString();
	}
	
	private String replaceIfMissingOrDefault(String origin, String defaultValue){
		if(isNumeric(defaultValue) && !isNumeric(origin)){
				return defaultValue;
		}
		else{
			if(origin.trim().equals("")){
				return defaultValue;
			}
		}
		return origin;
	}
	
	public static boolean isNumeric(String s){
		char[]sArray = s.toCharArray();
		for(char c : sArray){
			if(!Character.isDigit(c)){
				return false;
			}
		}
		return true;
	}
}
