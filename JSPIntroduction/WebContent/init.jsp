<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Overiding init method -->
	<%!
		public void jspInit(){
			String defaultUser = getServletConfig().getInitParameter("defaultName");
			int age = Integer.parseInt(getServletConfig().getInitParameter("age"));
			ServletContext context = getServletContext();
			context.setAttribute("defaultName", defaultUser);
			context.setAttribute("age", age);
		}
	
	%>
	<h3>Test of initial parameters:</h3>
	This is default name from servlet config: <%=getServletConfig().getInitParameter("defaultName") %>
	<br/>
	This is default age from servlet config: <%=getServletConfig().getInitParameter("age") %>
	<br/><br/>
	Data retrieved from context: <br/>
	This is default age from servlet context: <%=getServletContext().getAttribute("defaultName")%>
	<br/>
	This is default name from servlet context: <%=getServletContext().getAttribute("age")%>
	
	
	
</body>
</html>