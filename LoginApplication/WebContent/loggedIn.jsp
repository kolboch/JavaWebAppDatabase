<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dto.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logged In view</title>
</head>
<body>
	<h3>Successfully logged in!</h3>
	<%
		User user = (User)request.getAttribute("user");
	%>
	Hello <%= user.getUserName() %>
</body>
</html>