<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page 
	import="java.util.Date"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>import and outer jsp</title>
</head>
<body>
	<h4>This is simple clock.</h4>
	<% 
		Date d1 = new Date();
		out.println("Seconds passed from 1970 january: " + d1.getTime());
		String date = d1.toString();
	%>
	<br/>
	<b>Today is: <%=date %>.</b>
	<br/>
	The following content is from the outer jsp file...<br/>
	<%@include file="simpleOuter.jsp" %>
</body>
</html>