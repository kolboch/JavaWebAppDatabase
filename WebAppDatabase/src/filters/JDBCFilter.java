package filters;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import conn.ConnectionUtils;
import utils.CookieUtils;

@WebFilter(filterName = "JDBCFilter", urlPatterns = { "/*" })
public class JDBCFilter implements Filter {
	
	public JDBCFilter(){
	}
	
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	
	private boolean needJDBC(HttpServletRequest request){
		System.out.println("JDBC Filter");
		
		String servletPath = request.getServletPath();
		String pathInfo = request.getPathInfo();
		
		String urlPattern = servletPath;
		
		if(pathInfo != null){
			urlPattern += "/*";
		}
		//getting all registered servlets
		// key servlet name, value registration
		Map<String, ? extends ServletRegistration> registeredMap = request.getServletContext().getServletRegistrations();
		Collection<? extends ServletRegistration> values = registeredMap.values();
		for(ServletRegistration sReg : values){
			Collection<String> mappings = sReg.getMappings();
			for(String s : mappings){
				if(s.contains(urlPattern)){
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		if(this.needJDBC(req)){
			System.out.println("Open connection for: " + req.getServletPath());
			
			Connection conn = null;
			try{
				conn = ConnectionUtils.getConnectionToDatabase();
				conn.setAutoCommit(false);
				CookieUtils.storeConnection(request, conn);
				chain.doFilter(request, response);
				conn.commit();
			}
			catch(SQLException e){
				e.printStackTrace();
				ConnectionUtils.rollBackQuietly(conn);
				throw new ServletException();
			}
			finally{
				ConnectionUtils.closeQuietly(conn);
			}
		}
		else{
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
	}

}
