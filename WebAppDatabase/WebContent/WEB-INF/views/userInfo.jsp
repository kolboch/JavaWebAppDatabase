<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Web App user info</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>
	
	<h3>Hello ${user.user_name}</h3>
	<br/>
	<table>
		<tr>
			<td>user name:</td>
			<td>${user.user_name}</td>
		</tr>
		<tr>
			<td>gender:</td>
			<td>${user.gender}</td>
		</tr>
	</table>
	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>