<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>testing JSP</title>
</head>
<body>
	<h2>This is JSP test.</h2>
	<br/>
	<%! 
		private int add(int a, int b){
			return a+b;
		}
		
	%>
	<%
		double radius = 4;
		double perimeter = 2 * radius * Math.PI;
		out.println(perimeter);
		perimeter /= 2;
	%>
	<br/>
	Another way of printing value: <%=perimeter %>. <br/>
	Using function: <%=add(40,55) %>
	
</body>
</html>