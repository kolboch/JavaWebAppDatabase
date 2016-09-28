package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LogFilter2 implements Filter{

	private String logFile;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.logFile = filterConfig.getInitParameter("logFile");
		System.out.println("Log file is: " + logFile);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if(this.logFile != null){
			this.logToFile(logFile);
		}
		chain.doFilter(request, response); // go to next element in chain
	}

	private void logToFile(String logFile){
		System.out.println("Write log to file: " + logFile);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
