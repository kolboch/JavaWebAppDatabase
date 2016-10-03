package filters;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.User_account;
import utils.CookieUtils;
import utils.DatabaseUtils;

@WebFilter(filterName = "CookieFilter", urlPatterns = { "/*" })
public class CookieFilter implements Filter {
	
	public CookieFilter(){
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		User_account logedIn = CookieUtils.getStoredLoginedUser(session);
	
		if(logedIn != null){
			session.setAttribute("COOKIE_CHECKED", "CHECKED");
			chain.doFilter(request, response);
			return;
		}
		
		Connection conn = CookieUtils.getStoredConnection(request);
		
		String checked = (String) session.getAttribute("COOKIE_CHECKED");
		if(checked == null && conn != null){
			String userName = CookieUtils.getUserNameFromCookie(req);
			try{
				User_account user = DatabaseUtils.findUser(conn, userName);
				CookieUtils.storeLoginedUser(session, user);
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			session.setAttribute("COOKIE_CHECKED", "CHECKED");
		}
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
}
