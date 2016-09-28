package filter;

import java.io.File;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"*.jpg", "*.jpeg", "*.gif", "*.png"},
	initParams = {
			@WebInitParam(name = "notFoundImage", value = "/images/notFound.jpeg")
	}
		)

public class ImageFilter implements Filter{

	private String notFoundImage;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		notFoundImage = filterConfig.getInitParameter("notFoundImage");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		String servletPath = req.getServletPath();
		System.out.println("Servlet Path: " + servletPath); // log control
		//the path to the root directory of webapp (WebContent)
		
		String realRootPath = req.getServletContext().getRealPath("");
		System.out.println("real root path: " + realRootPath); // log control
		
		//real path of image
		String imageRealPath = realRootPath + servletPath;
		System.out.println("Image Real path: " + imageRealPath);
		
		File file = new File(imageRealPath);
		if(file.exists()){
			chain.doFilter(request, response);
		}
		else if(!servletPath.equals(this.notFoundImage)){
			// redirect to image not found image
			HttpServletResponse resp = (HttpServletResponse)response;
			resp.sendRedirect(req.getContextPath() + this.notFoundImage);
		}
	}

	@Override
	public void destroy() {
	}

}
