<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test of context</title>
</head>
<body>
	<h4>Test of input, session and context:</h4><br/>
	<%
		String name = request.getParameter("name");
		if(name == null || name.trim().equals("")){
			name = (String)session.getAttribute("name");
			if(name == null){
				name = (String)application.getAttribute("name");
			}
		}
		else{
			session.setAttribute("name", name);
			application.setAttribute("name", name);
			pageContext.setAttribute("name", name, PageContext.APPLICATION_SCOPE);
		}
	%>
	Hello <%=name%>
	<br/>
	Now details of background retrieving that value:<br/>
	Direct parameter in request is: <%=request.getParameter("name") %>
	<br/>
	In session parameter is: <%=(String)session.getAttribute("name") %>
	<br/>
	In application parameter is: <%=(String)application.getAttribute("name") %>
</body>
</html>